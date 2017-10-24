/*
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 *
 */

/*
 * @test
 * @summary Abort dumping if any of the new jigsaw vm options is specified.
 * AppCDS does not support uncompressed oops
 * @requires (vm.opt.UseCompressedOops == null) | (vm.opt.UseCompressedOops == true)
 * @library /test/lib ..
 * @modules java.base/jdk.internal.misc
 *          java.management
 *          jdk.jartool/sun.tools.jar
 *          jdk.internal.jvmstat/sun.jvmstat.monitor
 * @compile ../test-classes/Hello.java
 * @run main CheckUnsupportedDumpingOptions
 */

import jdk.test.lib.compiler.InMemoryJavaCompiler;
import jdk.test.lib.process.OutputAnalyzer;

public class CheckUnsupportedDumpingOptions {
    private static final String[] jigsawOptions = {
        "-m",
        "--limit-modules",
        "--module-path",
        "--upgrade-module-path",
        "--patch-module"
    };
    private static final String[] optionValues = {
        "mymod",
        "mymod",
        "mydir",
        ".",
        "java.naming=javax.naming.spi.NamingManger"
    };
    private static final int infoIdx = 1;

    public static void main(String[] args) throws Exception {
        String source = "package javax.naming.spi; "                +
                        "public class NamingManager { "             +
                        "    static { "                             +
                        "        System.out.println(\"I pass!\"); " +
                        "    } "                                    +
                        "}";
        ClassFileInstaller.writeClassToDisk("javax/naming/spi/NamingManager",
            InMemoryJavaCompiler.compile("javax.naming.spi.NamingManager", source, "--patch-module=java.naming"),
            "mods/java.naming");

        JarBuilder.build("hello", "Hello");
        String appJar = TestCommon.getTestJar("hello.jar");
        String appClasses[] = {"Hello"};
        for (int i = 0; i < jigsawOptions.length; i++) {
            OutputAnalyzer output;
            if (i == 5) {
                // --patch-module
                output = TestCommon.dump(appJar, appClasses, "-Xlog:cds,cds+hashtables",
                                         jigsawOptions[i] + optionValues[i] + appJar);
            } else {
                output = TestCommon.dump(appJar, appClasses, "-Xlog:cds,cds+hashtables",
                                         jigsawOptions[i], optionValues[i]);
            }
            if (i < infoIdx) {
                output.shouldContain("Cannot use the following option " +
                    "when dumping the shared archive: " + jigsawOptions[i])
                      .shouldHaveExitValue(1);
            } else {
                output.shouldContain("Info: the " + jigsawOptions[i] +
                    " option is ignored when dumping the shared archive");
                if (optionValues[i].equals("mymod")) {
                      // java will throw FindException for a module
                      // which cannot be found during init_phase2() of vm init
                      output.shouldHaveExitValue(1)
                            .shouldContain("java.lang.module.FindException: Module mymod not found");
                } else {
                      output.shouldHaveExitValue(0);
                }
            }
        }
    }
}
