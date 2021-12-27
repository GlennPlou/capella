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
package org.polarsys.capella.common.helpers.query.cache;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Provide a cache to get and store the result of the computation of queries.
 */
public class QueryResultCache {

  /**
   * Cache.
   */
  private final Map<Object, Collection<Object>> computedElements = new HashMap<>();

  /**
   * Singleton.
   */
  private static QueryResultCache instance = null;

  /**
   * Singleton constructor.
   */
  private QueryResultCache() {
    // nothing to do.
  }

  /**
   * Singleton accessor.
   * 
   * @return
   */
  public static QueryResultCache getInstance() {
    if (instance == null) {
      instance = new QueryResultCache();
    }
    return instance;
  }

  /**
   * Cache accessor.
   * 
   * @return
   */
  public Map<Object, Collection<Object>> getCache() {
    return computedElements;
  }
}
