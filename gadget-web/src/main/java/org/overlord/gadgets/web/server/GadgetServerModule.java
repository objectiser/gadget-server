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
package org.overlord.gadgets.web.server;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scopes;

/**
 * @author: Jeff Yu
 * @date: 13/04/12
 */
public class GadgetServerModule implements Module {

    @Override
    public void configure(Binder binder) {
        binder.bind(UserController.class);
        binder.bind(StoreController.class);
        binder.bind(GadgetMetadataService.class).to(ShindigGadgetMetadataService.class).in(Scopes.SINGLETON);
    }
}
