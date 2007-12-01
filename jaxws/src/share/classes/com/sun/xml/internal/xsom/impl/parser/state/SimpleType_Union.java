/*
 * Copyright 2006 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Sun designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Sun in the LICENSE file that accompanied this code.
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
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 */

/* this file is generated by RelaxNGCC */
package com.sun.xml.internal.xsom.impl.parser.state;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.Attributes;
import com.sun.xml.internal.xsom.impl.parser.NGCCRuntimeEx;

    import com.sun.xml.internal.xsom.*;
    import com.sun.xml.internal.xsom.parser.*;
    import com.sun.xml.internal.xsom.impl.*;
    import com.sun.xml.internal.xsom.impl.parser.*;
    import org.xml.sax.Locator;
    import org.xml.sax.ContentHandler;
    import org.xml.sax.helpers.*;
    import java.util.*;

import java.util.Vector;


class SimpleType_Union extends NGCCHandler {
    private Locator locator;
    private AnnotationImpl annotation;
    private String __text;
    private UName memberTypeName;
    private String name;
    private Set finalSet;
    private ForeignAttributesImpl fa;
    private SimpleTypeImpl anonymousMemberType;
    protected final NGCCRuntimeEx $runtime;
    private int $_ngcc_current_state;
    protected String $uri;
    protected String $localName;
    protected String $qname;

    public final NGCCRuntime getRuntime() {
        return($runtime);
    }

    public SimpleType_Union(NGCCHandler parent, NGCCEventSource source, NGCCRuntimeEx runtime, int cookie, AnnotationImpl _annotation, Locator _locator, ForeignAttributesImpl _fa, String _name, Set _finalSet) {
        super(source, parent, cookie);
        $runtime = runtime;
        this.annotation = _annotation;
        this.locator = _locator;
        this.fa = _fa;
        this.name = _name;
        this.finalSet = _finalSet;
        $_ngcc_current_state = 12;
    }

    public SimpleType_Union(NGCCRuntimeEx runtime, AnnotationImpl _annotation, Locator _locator, ForeignAttributesImpl _fa, String _name, Set _finalSet) {
        this(null, runtime, runtime, -1, _annotation, _locator, _fa, _name, _finalSet);
    }

    private void action0()throws SAXException {

                        result = new UnionSimpleTypeImpl(
                                $runtime.document, annotation, locator, fa, name, name==null, finalSet,
                                (Ref.SimpleType[])members.toArray(new Ref.SimpleType[members.size()]) );

}

    private void action1()throws SAXException {

          members.add(anonymousMemberType);

}

    private void action2()throws SAXException {

                members.add( new DelayedRef.SimpleType(
                                $runtime, uloc, $runtime.currentSchema, memberTypeName));

}

    private void action3()throws SAXException {
        $runtime.processList(__text);}

    private void action4()throws SAXException {
        uloc=$runtime.copyLocator();
}

    public void enterElement(String $__uri, String $__local, String $__qname, Attributes $attrs) throws SAXException {
        int $ai;
        $uri = $__uri;
        $localName = $__local;
        $qname = $__qname;
        switch($_ngcc_current_state) {
        case 0:
            {
                revertToParentFromEnterElement(result, super._cookie, $__uri, $__local, $__qname, $attrs);
            }
            break;
        case 1:
            {
                if(($__uri.equals("http://www.w3.org/2001/XMLSchema") && $__local.equals("simpleType"))) {
                    NGCCHandler h = new simpleType(this, super._source, $runtime, 631);
                    spawnChildFromEnterElement(h, $__uri, $__local, $__qname, $attrs);
                }
                else {
                    unexpectedEnterElement($__qname);
                }
            }
            break;
        case 6:
            {
                if((($__uri.equals("http://www.w3.org/2001/XMLSchema") && $__local.equals("annotation")) || ($__uri.equals("http://www.w3.org/2001/XMLSchema") && $__local.equals("simpleType")))) {
                    NGCCHandler h = new foreignAttributes(this, super._source, $runtime, 637, fa);
                    spawnChildFromEnterElement(h, $__uri, $__local, $__qname, $attrs);
                }
                else {
                    unexpectedEnterElement($__qname);
                }
            }
            break;
        case 7:
            {
                if(($ai = $runtime.getAttributeIndex("","memberTypes"))>=0) {
                    $runtime.consumeAttribute($ai);
                    $runtime.sendEnterElement(super._cookie, $__uri, $__local, $__qname, $attrs);
                }
                else {
                    $_ngcc_current_state = 6;
                    $runtime.sendEnterElement(super._cookie, $__uri, $__local, $__qname, $attrs);
                }
            }
            break;
        case 12:
            {
                if(($__uri.equals("http://www.w3.org/2001/XMLSchema") && $__local.equals("union"))) {
                    $runtime.onEnterElementConsumed($__uri, $__local, $__qname, $attrs);
                    action4();
                    $_ngcc_current_state = 7;
                }
                else {
                    unexpectedEnterElement($__qname);
                }
            }
            break;
        case 2:
            {
                if(($__uri.equals("http://www.w3.org/2001/XMLSchema") && $__local.equals("simpleType"))) {
                    NGCCHandler h = new simpleType(this, super._source, $runtime, 632);
                    spawnChildFromEnterElement(h, $__uri, $__local, $__qname, $attrs);
                }
                else {
                    $_ngcc_current_state = 1;
                    $runtime.sendEnterElement(super._cookie, $__uri, $__local, $__qname, $attrs);
                }
            }
            break;
        case 4:
            {
                if(($__uri.equals("http://www.w3.org/2001/XMLSchema") && $__local.equals("annotation"))) {
                    NGCCHandler h = new annotation(this, super._source, $runtime, 635, annotation,AnnotationContext.SIMPLETYPE_DECL);
                    spawnChildFromEnterElement(h, $__uri, $__local, $__qname, $attrs);
                }
                else {
                    $_ngcc_current_state = 2;
                    $runtime.sendEnterElement(super._cookie, $__uri, $__local, $__qname, $attrs);
                }
            }
            break;
        default:
            {
                unexpectedEnterElement($__qname);
            }
            break;
        }
    }

    public void leaveElement(String $__uri, String $__local, String $__qname) throws SAXException {
        int $ai;
        $uri = $__uri;
        $localName = $__local;
        $qname = $__qname;
        switch($_ngcc_current_state) {
        case 0:
            {
                revertToParentFromLeaveElement(result, super._cookie, $__uri, $__local, $__qname);
            }
            break;
        case 1:
            {
                if(($__uri.equals("http://www.w3.org/2001/XMLSchema") && $__local.equals("union"))) {
                    $runtime.onLeaveElementConsumed($__uri, $__local, $__qname);
                    $_ngcc_current_state = 0;
                    action0();
                }
                else {
                    unexpectedLeaveElement($__qname);
                }
            }
            break;
        case 6:
            {
                if(($__uri.equals("http://www.w3.org/2001/XMLSchema") && $__local.equals("union"))) {
                    NGCCHandler h = new foreignAttributes(this, super._source, $runtime, 637, fa);
                    spawnChildFromLeaveElement(h, $__uri, $__local, $__qname);
                }
                else {
                    unexpectedLeaveElement($__qname);
                }
            }
            break;
        case 7:
            {
                if(($ai = $runtime.getAttributeIndex("","memberTypes"))>=0) {
                    $runtime.consumeAttribute($ai);
                    $runtime.sendLeaveElement(super._cookie, $__uri, $__local, $__qname);
                }
                else {
                    $_ngcc_current_state = 6;
                    $runtime.sendLeaveElement(super._cookie, $__uri, $__local, $__qname);
                }
            }
            break;
        case 2:
            {
                $_ngcc_current_state = 1;
                $runtime.sendLeaveElement(super._cookie, $__uri, $__local, $__qname);
            }
            break;
        case 4:
            {
                $_ngcc_current_state = 2;
                $runtime.sendLeaveElement(super._cookie, $__uri, $__local, $__qname);
            }
            break;
        default:
            {
                unexpectedLeaveElement($__qname);
            }
            break;
        }
    }

    public void enterAttribute(String $__uri, String $__local, String $__qname) throws SAXException {
        int $ai;
        $uri = $__uri;
        $localName = $__local;
        $qname = $__qname;
        switch($_ngcc_current_state) {
        case 0:
            {
                revertToParentFromEnterAttribute(result, super._cookie, $__uri, $__local, $__qname);
            }
            break;
        case 7:
            {
                if(($__uri.equals("") && $__local.equals("memberTypes"))) {
                    $_ngcc_current_state = 10;
                }
                else {
                    $_ngcc_current_state = 6;
                    $runtime.sendEnterAttribute(super._cookie, $__uri, $__local, $__qname);
                }
            }
            break;
        case 2:
            {
                $_ngcc_current_state = 1;
                $runtime.sendEnterAttribute(super._cookie, $__uri, $__local, $__qname);
            }
            break;
        case 4:
            {
                $_ngcc_current_state = 2;
                $runtime.sendEnterAttribute(super._cookie, $__uri, $__local, $__qname);
            }
            break;
        default:
            {
                unexpectedEnterAttribute($__qname);
            }
            break;
        }
    }

    public void leaveAttribute(String $__uri, String $__local, String $__qname) throws SAXException {
        int $ai;
        $uri = $__uri;
        $localName = $__local;
        $qname = $__qname;
        switch($_ngcc_current_state) {
        case 0:
            {
                revertToParentFromLeaveAttribute(result, super._cookie, $__uri, $__local, $__qname);
            }
            break;
        case 8:
            {
                if(($__uri.equals("") && $__local.equals("memberTypes"))) {
                    $_ngcc_current_state = 6;
                }
                else {
                    unexpectedLeaveAttribute($__qname);
                }
            }
            break;
        case 7:
            {
                $_ngcc_current_state = 6;
                $runtime.sendLeaveAttribute(super._cookie, $__uri, $__local, $__qname);
            }
            break;
        case 2:
            {
                $_ngcc_current_state = 1;
                $runtime.sendLeaveAttribute(super._cookie, $__uri, $__local, $__qname);
            }
            break;
        case 4:
            {
                $_ngcc_current_state = 2;
                $runtime.sendLeaveAttribute(super._cookie, $__uri, $__local, $__qname);
            }
            break;
        default:
            {
                unexpectedLeaveAttribute($__qname);
            }
            break;
        }
    }

    public void text(String $value) throws SAXException {
        int $ai;
        switch($_ngcc_current_state) {
        case 0:
            {
                revertToParentFromText(result, super._cookie, $value);
            }
            break;
        case 9:
            {
                NGCCHandler h = new qname(this, super._source, $runtime, 639);
                spawnChildFromText(h, $value);
            }
            break;
        case 8:
            {
                NGCCHandler h = new qname(this, super._source, $runtime, 640);
                spawnChildFromText(h, $value);
            }
            break;
        case 7:
            {
                if(($ai = $runtime.getAttributeIndex("","memberTypes"))>=0) {
                    $runtime.consumeAttribute($ai);
                    $runtime.sendText(super._cookie, $value);
                }
                else {
                    $_ngcc_current_state = 6;
                    $runtime.sendText(super._cookie, $value);
                }
            }
            break;
        case 2:
            {
                $_ngcc_current_state = 1;
                $runtime.sendText(super._cookie, $value);
            }
            break;
        case 4:
            {
                $_ngcc_current_state = 2;
                $runtime.sendText(super._cookie, $value);
            }
            break;
        case 10:
            {
                __text = $value;
                $_ngcc_current_state = 9;
                action3();
            }
            break;
        }
    }

    public void onChildCompleted(Object $__result__, int $__cookie__, boolean $__needAttCheck__)throws SAXException {
        switch($__cookie__) {
        case 637:
            {
                fa = ((ForeignAttributesImpl)$__result__);
                $_ngcc_current_state = 4;
            }
            break;
        case 640:
            {
                memberTypeName = ((UName)$__result__);
                action2();
                $_ngcc_current_state = 8;
            }
            break;
        case 631:
            {
                anonymousMemberType = ((SimpleTypeImpl)$__result__);
                action1();
                $_ngcc_current_state = 1;
            }
            break;
        case 639:
            {
                memberTypeName = ((UName)$__result__);
                action2();
                $_ngcc_current_state = 8;
            }
            break;
        case 632:
            {
                anonymousMemberType = ((SimpleTypeImpl)$__result__);
                action1();
                $_ngcc_current_state = 1;
            }
            break;
        case 635:
            {
                annotation = ((AnnotationImpl)$__result__);
                $_ngcc_current_state = 2;
            }
            break;
        }
    }

    public boolean accepted() {
        return(($_ngcc_current_state == 0));
    }


                /** computed simple type object */
                private UnionSimpleTypeImpl result;

                // Vector of Ref.SimpleType
                private final Vector members = new Vector();

                // locator of <union>
                private Locator uloc;

}
