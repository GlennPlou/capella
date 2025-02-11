/*******************************************************************************
 * Copyright (c) 2022 THALES GLOBAL SERVICES.
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
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.helpers.query.IQuery;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.cs.CsPackage;
import org.polarsys.capella.core.data.cs.Part;
import org.polarsys.capella.core.data.cs.PhysicalPath;
import org.polarsys.capella.core.model.helpers.PhysicalPathExt;

/**
 */
public class PhysicalPath_PhysicalComponents implements IQuery {

  /**
   * @see org.polarsys.capella.common.helpers.query.IQuery#compute(java.lang.Object)
   */
  public List<Object> compute(Object object) {
    List<Object> result = new ArrayList<>();
    // Check expected type.
    if (object instanceof PhysicalPath) {
      PhysicalPath path = (PhysicalPath) object;

      for (EObject obj : PhysicalPathExt.getFlatInvolvedElements(path, CsPackage.Literals.PART)) {
        if (obj instanceof Part) {
          Part p = (Part) obj;
          if (p.getAbstractType() instanceof Component) {
            result.add(p.getAbstractType());
          }
        }
      }
    }
    return result;
  }

}
