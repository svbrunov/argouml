// Copyright (c) 1996-98 The Regents of the University of California. All
// Rights Reserved. Permission to use, copy, modify, and distribute this
// software and its documentation for educational, research and non-profit
// purposes, without fee, and without a written agreement is hereby granted,
// provided that the above copyright notice and this paragraph appear in all
// copies. Permission to incorporate this software into commercial products
// must be negotiated with University of California. This software program and
// documentation are copyrighted by The Regents of the University of
// California. The software program and documentation are supplied "as is",
// without any accompanying services from The Regents. The Regents do not
// warrant that the operation of the program will be uninterrupted or
// error-free. The end-user understands that the program was developed for
// research purposes and is advised not to rely exclusively on the program for
// any reason. IN NO EVENT SHALL THE UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY
// PARTY FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES,
// INCLUDING LOST PROFITS, ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS
// DOCUMENTATION, EVEN IF THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE
// POSSIBILITY OF SUCH DAMAGE. THE UNIVERSITY OF CALIFORNIA SPECIFICALLY
// DISCLAIMS ANY WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
// WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE
// SOFTWARE PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
// CALIFORNIA HAS NO OBLIGATIONS TO PROVIDE MAINTENANCE, SUPPORT, UPDATES,
// ENHANCEMENTS, OR MODIFICATIONS.

// File: CrInvalidBranch.java
// Classes: CrInvalidBranch
// Original Author: jrobbins@ics.uci.edu
// $Id$

package uci.uml.critics;

import java.util.*;
import uci.argo.kernel.*;
import uci.util.*;
import uci.uml.Foundation.Core.*;
import uci.uml.Foundation.Data_Types.*;
import uci.uml.Behavioral_Elements.State_Machines.*;

/** A critic to detect when a Branch state has the wrong number of
 *  transitions.  Implements constraint [6] on Pseudostate in the UML
 *  Semantics v1.1, pp. 104. */

public class CrInvalidBranch extends CrUML {

  public CrInvalidBranch() {
    setHeadline("Change Branch Transitions");
    sd("This branch state has an invalid number of transitions. Normally "+
       "branch states have one incoming and two or more outgoing transitions. \n\n"+
       "Defining correct state transitions is needed to complete the  "+
       "behavioral specification part of your design.  \n\n"+
       "To fix this, press the \"Next>\" button, or remove transitions  "+
       "manually by clicking on transition in the diagram and pressing the "+
       "Delete key, or add transitions using the transition tool. ");

    addSupportedDecision(CrUML.decSTATE_MACHINES);
    addTrigger("incoming");
  }

  public boolean predicate2(Object dm, Designer dsgr) {
    if (!(dm instanceof Pseudostate)) return NO_PROBLEM;
    Pseudostate ps = (Pseudostate) dm;
    PseudostateKind k = ps.getKind();
    if (!PseudostateKind.BRANCH.equals(k)) return NO_PROBLEM;
    Vector outgoing = ps.getOutgoing();
    Vector incoming = ps.getIncoming();
    int nOutgoing = outgoing == null ? 0 : outgoing.size();
    int nIncoming = incoming == null ? 0 : incoming.size();
    if (nIncoming > 1) return PROBLEM_FOUND;
    if (nOutgoing == 1) return PROBLEM_FOUND;
    return NO_PROBLEM;
  }

} /* end class CrInvalidBranch */

