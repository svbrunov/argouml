// $Id$
// Copyright (c) 1996-2005 The Regents of the University of California. All
// Rights Reserved. Permission to use, copy, modify, and distribute this
// software and its documentation without fee, and without a written
// agreement is hereby granted, provided that the above copyright notice
// and this paragraph appear in all copies.  This software program and
// documentation are copyrighted by The Regents of the University of
// California. The software program and documentation are supplied "AS
// IS", without any accompanying services from The Regents. The Regents
// does not warrant that the operation of the program will be
// uninterrupted or error-free. The end-user understands that the program
// was developed for research purposes and is advised not to rely
// exclusively on the program for any reason.  IN NO EVENT SHALL THE
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

package org.argouml.model.uml;

import java.util.Collection;

import org.argouml.model.CommonBehaviorHelper;
import org.argouml.model.ModelFacade;

import ru.novosoft.uml.behavior.common_behavior.MLinkEnd;

/**
 * Helper class for UML BehavioralElements::CommonBehavior Package.
 *
 * @since ARGO0.11.2
 * @author Thierry Lach
 */
class CommonBehaviorHelperImpl implements CommonBehaviorHelper {

    /**
     * Don't allow instantiation.
     */
    CommonBehaviorHelperImpl() {
    }

    /**
     * Returns the source of a link. The source of a binary link is defined as
     * the instance where the first linkend is pointing to via the association
     * instance.
     *
     * @param link the given link
     * @return MInstance the source of the given link
     */
    public Object getSource(Object link) {
        Collection con = ModelFacade.getConnections(link);
        if (con.isEmpty()) {
            return null;
        }
        MLinkEnd le0 = (MLinkEnd) (con.toArray())[0];
        return le0.getInstance();
    }

    /**
     * Returns the destination of a link. The destination of a binary link is
     * defined as the instance where the second linkend is pointing to via the
     * association instance.
     * @param link the given link
     * @return MInstance the destination of the given link
     */
    public Object getDestination(Object link) {
        Collection con = ModelFacade.getConnections(link);
        if (con.size() <= 1) {
            return null;
        }
        MLinkEnd le0 = (MLinkEnd) (con.toArray())[1];
        return le0.getInstance();
    }

}
