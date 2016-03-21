/*******************************************************************************
 * Copyright (c) 2006, 2016 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/

package org.polarsys.capella.common.menu.dynamic;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.widgets.Shell;

import org.polarsys.kitalpha.emde.model.Element;

/**
 * Base class to implement action dealing with a model element.
 */
public abstract class AbstractModelElementAction extends AbstractNavigatorAction {
  /**
   * Managed model element.
   */
  private Element _modelElement;

  /**
   * Constructor.
   * @param shell
   * @param selectionProvider
   */
  protected AbstractModelElementAction(Shell shell, ISelectionProvider selectionProvider) {
    super(shell, selectionProvider);
    // Set action id based on class name.
    setId(getClass().getName());
  }

  /**
   * @see org.polarsys.capella.common.mdsofa.rootasset.ui.workbench.action.navigator.AbstractNavigatorAction#setSelectedElement(java.lang.Object)
   */
  @Override
  public void setSelectedElement(Object object) {
    if (object instanceof Element) {
      _modelElement = (Element) object;
    }
  }

  /**
   * Get the editing model element.
   * @return the modelElement
   */
  public Element getModelElement() {
    return _modelElement;
  }

  /**
   * Execute the command.
   * @param editingDomain
   * @param command
   */
  protected void executeCommand(AdapterFactoryEditingDomain editingDomain, Command command) {
    editingDomain.getCommandStack().execute(command);
  }
}
