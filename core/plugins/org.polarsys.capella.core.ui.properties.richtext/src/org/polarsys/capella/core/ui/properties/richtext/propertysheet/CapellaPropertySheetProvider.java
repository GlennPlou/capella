/*******************************************************************************
 * Copyright (c) 2017, 2020 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.core.ui.properties.richtext.propertysheet;

import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.polarsys.capella.core.ui.properties.CapellaTabbedPropertySheetPage;
import org.polarsys.kitalpha.richtext.widget.editor.MDERichTextEditor;
import org.polarsys.kitalpha.richtext.widget.propertysheet.MDERichTextPropertySheetProvider;

public class CapellaPropertySheetProvider implements MDERichTextPropertySheetProvider {

    public CapellaPropertySheetProvider() {
    }

    @Override
    public TabbedPropertySheetPage getTabbedPropertySheetPageDelegate(final MDERichTextEditor contributor) {
        return new CapellaTabbedPropertySheetPage(contributor) {
            @Override
            public void init(IPageSite pageSite) {
                super.init(pageSite);
                pageSite.setSelectionProvider(contributor.getSite().getSelectionProvider());
            }
        };
    }

}
