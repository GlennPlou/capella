/*******************************************************************************
 * Copyright (c) 2006, 2020 THALES GLOBAL SERVICES.
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

import org.polarsys.capella.core.data.information.ExchangeItemElement;
import org.polarsys.capella.common.data.modellingcore.AbstractType;
import org.polarsys.capella.common.helpers.query.IQuery;

/**
 * Return ExchangeItemElement Type
 * 
 */
public class ExchangeItemElementType implements IQuery {

  /**
	 * 
	 */
  public ExchangeItemElementType() {
    // Does nothing
  }

  /**
   * 
   * current.flowSource.ownerElement
   * 
   * @see org.polarsys.capella.common.helpers.query.IQuery#compute(java.lang.Object)
   */
  public List<Object> compute(Object object) {
    List<Object> result = new ArrayList<Object>();
    if (object instanceof ExchangeItemElement) {
      ExchangeItemElement exchangeItemElement = (ExchangeItemElement) object;
      AbstractType abstractType = exchangeItemElement.getAbstractType();
      if (null != abstractType) {
        result.add(abstractType);
      }
    }
    return result;
  }
}
