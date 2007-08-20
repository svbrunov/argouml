// $Id:PropPanelPermission.java 13230 2007-08-03 20:08:03Z tfmorris $
// Copyright (c) 1996-2006 The Regents of the University of California. All
// Rights Reserved. Permission to use, copy, modify, and distribute this
// software and its documentation without fee, and without a written
// agreement is hereby granted, provided that the above copyright notice
// and this paragraph appear in all copies. This software program and
// documentation are copyrighted by The Regents of the University of
// California. The software program and documentation are supplied "AS
// IS", without any accompanying services from The Regents. The Regents
// does not warrant that the operation of the program will be
// uninterrupted or error-free. The end-user understands that the program
// was developed for research purposes and is advised not to rely
// exclusively on the program for any reason. IN NO EVENT SHALL THE
// UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT,
// SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES, INCLUDING LOST PROFITS,
// ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
// THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
// SUCH DAMAGE. THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY
// WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
// MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
// PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
// CALIFORNIA HAS NO OBLIGATIONS TO PROVIDE MAINTENANCE, SUPPORT,
// UPDATES, ENHANCEMENTS, OR MODIFICATIONS.

package org.argouml.uml.ui.foundation.core;

import org.argouml.i18n.Translator;
import org.argouml.uml.ui.ActionNavigateNamespace;
import org.argouml.util.ConfigLoader;

/**
 * The properties panel for a Permission.
 * <p>
 * TODO: In UML 2.x, the import and access Permissions have become
 * PackageImports with public visibility and non-public visibility respectively.
 * (ArgoUML only supports the <<import>> Permission currently). The friend
 * Permission has been dropped. Also the type hierarchy has been reorganized so
 * that PackageImport is not a subtype of Dependency.
 */
public class PropPanelPermission extends PropPanelDependency {

    /**
     * The serial version.
     */
    private static final long serialVersionUID = 5724713380091275451L;

    /**
     * Construct a property panel for UML Permission elements.
     */
    public PropPanelPermission() {
        super("Permission", ConfigLoader.getTabPropsOrientation());

        addField(Translator.localize("label.name"),
                getNameTextField());
        addField(Translator.localize("label.namespace"),
                getNamespaceSelector());

        addSeparator();

        addField(Translator.localize("label.suppliers"),
                getSupplierScroll());
        addField(Translator.localize("label.clients"),
                getClientScroll());

        addAction(new ActionNavigateNamespace());
        addAction(getDeleteAction());
    }

}

