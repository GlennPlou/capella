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
package org.polarsys.capella.test.diagram.tools.ju.xab;

import org.eclipse.sirius.business.api.session.Session;

import org.polarsys.capella.test.diagram.common.ju.context.PABDiagram;
import org.polarsys.capella.test.framework.context.SessionContext;

public class ManageBehaviorPCsDeployment extends XABDiagramsProject {

  @Override
  public void test() throws Exception {
    Session session = getSession(getRequiredTestModel());
    SessionContext context = new SessionContext(session);

    testOnXAB(context, PA__PAB_DIAGRAM, PA__PAB_COMPONENT_PC3_2,
        PA__PAB_COMPONENT_PC3);
  }

  public void testOnXAB(SessionContext context, String diagramName, String behaviorCompID, String containerId) {
    PABDiagram pabDiagram = PABDiagram.openDiagram(context, diagramName);

    pabDiagram.removeBehaviorComponent(behaviorCompID, containerId);
    pabDiagram.manageBehaviorPCsDeployment(behaviorCompID, containerId);
  }

  
}
