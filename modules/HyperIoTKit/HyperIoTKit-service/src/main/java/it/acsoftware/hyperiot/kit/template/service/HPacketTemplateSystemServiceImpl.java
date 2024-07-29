/*
 Copyright 2019-2023 ACSoftware

 Licensed under the Apache License, Version 2.0 (the "License")
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.

 */

package it.acsoftware.hyperiot.kit.template.service;


import it.acsoftware.hyperiot.base.service.entity.HyperIoTBaseEntitySystemServiceImpl;
import it.acsoftware.hyperiot.kit.template.api.HPacketTemplateRepository;
import it.acsoftware.hyperiot.kit.template.api.HPacketTemplateSystemApi;
import it.acsoftware.hyperiot.kit.template.model.HPacketTemplate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = HPacketTemplateSystemApi.class, immediate = true)
public class HPacketTemplateSystemServiceImpl extends HyperIoTBaseEntitySystemServiceImpl<HPacketTemplate> implements HPacketTemplateSystemApi {

    private HPacketTemplateRepository repository;


    public HPacketTemplateSystemServiceImpl() {
        super(HPacketTemplate.class);
    }

    @Override
    protected HPacketTemplateRepository getRepository() {
        getLog().debug("invoking getRepository, returning: {}" , this.repository);
        return repository;
    }

    @Reference
    protected void setRepository(HPacketTemplateRepository repository) {
        getLog().debug("invoking setRepository, setting: {}" , repository);
        this.repository = repository;
    }
}
