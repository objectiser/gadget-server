/*
 * JBoss, Home of Professional Open Source
 * Copyright 2008-11, Red Hat Middleware LLC, and others contributors as indicated
 * by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */
package org.savara.gserver.web.client.view;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.*;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import org.savara.gserver.web.client.ApplicationEntryPoint;
import org.savara.gserver.web.client.presenter.IndexPresenter;
import org.savara.gserver.web.client.widgets.*;

/**
 * @author: Jeff Yu
 * @date: 20/02/12
 */
public class IndexViewImpl extends ViewImpl implements IndexPresenter.IndexView {

    private LayoutPanel headerPanel;
    private TabLayout mainContentPanel;
    private LayoutPanel footerPanel;

    private DockLayoutPanel panel;

    @Inject
    public IndexViewImpl() {
        mainContentPanel = new TabLayout();

        PortalLayout portalLayout = new PortalLayout(3);
        
        Portlet samGadget = new Portlet("SAM-Gadget", "http://sam-gadget.appspot.com/Gadget/SamGadget.gadget.xml");
        Portlet ccGadget = new Portlet("Currency-Converter", "http://hosting.gmodules.com/ig/gadgets/file/112016200750717054421/currency-converter.xml");
        PortletLayout moreInfo = new PortletLayout("Links", "InformationTest");
        portalLayout.addPortlet(0, samGadget);
        portalLayout.addPortlet(1, moreInfo);
        portalLayout.addPortlet(2, ccGadget);

        mainContentPanel.addTab("Home", portalLayout);
        
        PortalLayout sndLayout = new PortalLayout(2);
        PortletLayout helloWorld = new PortletLayout("HelloWorld", "Hello World Portlet");
        sndLayout.addPortlet(0, helloWorld);

        mainContentPanel.addTab("Finance", sndLayout);

        headerPanel = new LayoutPanel();
        headerPanel.setStyleName("header-panel");

        footerPanel = new LayoutPanel();
        footerPanel.setStyleName("footer-panel");

        panel = new DockLayoutPanel(Style.Unit.PX);
        panel.getElement().setAttribute("id", "container");

        panel.addNorth(headerPanel, 110);
        panel.addSouth(footerPanel, 25);
        panel.add(mainContentPanel);

        getHeaderPanel().add(ApplicationEntryPoint.MODULES.getHeader().asWidget());
        getFooterPanel().add(ApplicationEntryPoint.MODULES.getFooter().asWidget());

    }

    public Widget asWidget() {
        return panel;
    }

    public LayoutPanel getHeaderPanel() {
        return headerPanel;
    }

    public LayoutPanel getFooterPanel() {
        return footerPanel;
    }

}
