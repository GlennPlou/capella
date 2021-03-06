/*******************************************************************************
 * Copyright (c) 2019, 2020 THALES GLOBAL SERVICES.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/

package org.polarsys.capella.core.semantic.queries.basic.queries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.polarsys.capella.common.helpers.query.IQuery;
import org.polarsys.capella.core.data.fa.FunctionalChainInvolvement;
import org.polarsys.capella.core.data.fa.FunctionalChainInvolvementFunction;

public class FunctionalChainInvolvementFunctionIncomingInvolvementLinks implements IQuery {

  public FunctionalChainInvolvementFunctionIncomingInvolvementLinks() {
    // do nothing
  }

  /**
   * @see org.polarsys.capella.common.helpers.query.IQuery#compute(java.lang.Object)
   */
  public List<Object> compute(Object object) {
    if (object instanceof FunctionalChainInvolvementFunction) {
      FunctionalChainInvolvementFunction functionalChainInvolvementFunction = (FunctionalChainInvolvementFunction) object;
      EList<FunctionalChainInvolvement> previousFunctionalChainInvolvements = functionalChainInvolvementFunction
          .getPreviousFunctionalChainInvolvements();
      return new ArrayList<>(previousFunctionalChainInvolvements);
    }
    return Collections.emptyList();
  }
}
