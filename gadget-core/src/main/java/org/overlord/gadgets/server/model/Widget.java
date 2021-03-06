/*
 * 2012-3 Red Hat Inc. and/or its affiliates and other contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.overlord.gadgets.server.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author: Jeff Yu
 * @date: 5/04/12
 */
@Entity
@Table(name="GS_WIDGET")
public class Widget implements Serializable{

	private static final long serialVersionUID = 3619016542917740925L;

	@Id
    @GeneratedValue
    @Column(name="WIDGET_ID")
    private long id;

    @Column(name="WIDGET_NAME")
    private String name;

    @Column(name="WIDGET_URL")
    private String appUrl;

    @Column(name="WIDGET_ORDER")
    private long order;
    
    @OneToMany(mappedBy = "widget", cascade= CascadeType.ALL)
    private List<WidgetPreference> prefs = new ArrayList<WidgetPreference>();

    @ManyToOne
    private Page page;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

	public List<WidgetPreference> getPrefs() {
		return prefs;
	}

	public void setPrefs(List<WidgetPreference> prefs) {
		this.prefs = prefs;
	}

}
