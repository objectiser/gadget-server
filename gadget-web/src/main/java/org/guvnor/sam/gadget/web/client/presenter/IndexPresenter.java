/*
 * JBoss, Home of Professional Open Source
 * Copyright 2008-12, Red Hat Middleware LLC, and others contributors as indicated
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
package org.guvnor.sam.gadget.web.client.presenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.http.client.RequestBuilder;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealRootLayoutContentEvent;

import org.guvnor.sam.gadget.web.client.NameTokens;
import org.guvnor.sam.gadget.web.client.URLBuilder;
import org.guvnor.sam.gadget.web.client.util.RestfulInvoker;
import org.guvnor.sam.gadget.web.shared.dto.PageModel;

import java.util.List;

/**
 * @author: Jeff Yu
 * @date: 20/02/12
 */
public class IndexPresenter extends Presenter<IndexPresenter.IndexView,
        IndexPresenter.IndexProxy>{

    @Inject
    public IndexPresenter(EventBus bus, IndexView view, IndexProxy proxy){
         super(bus, view, proxy);
    }

    @Override
    protected void revealInParent() {
        RevealRootLayoutContentEvent.fire(this, this);
    }

    public interface IndexView extends View {
        public void setPresenter(IndexPresenter presenter);
        //public void setPageModel(List<PageModel> models);
    }
    
    public void getPages(Long userId, RestfulInvoker.Response callback) {
        RestfulInvoker.invoke(RequestBuilder.GET, URLBuilder.getPagesURL(userId), null, callback);
    }

    @ProxyCodeSplit
    @NameToken(NameTokens.INDEX_VIEW)
    @NoGatekeeper
    public interface IndexProxy extends ProxyPlace<IndexPresenter> {}


    @Override
    public void onBind() {
        super.onBind();
        getView().setPresenter(this);


    }
}
