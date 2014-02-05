/**
 * Copyright (C) 2013 Motown.IO (info@motown.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.motown.operatorapi.viewmodel.model;

import io.motown.domain.api.chargingstation.Evse;

import java.util.Map;
import java.util.Set;

public class ConfigureChargingStationApiCommand implements ApiCommand {

    private Set<Evse> evses;

    private Map<String, String> settings;

    public ConfigureChargingStationApiCommand() {
    }

    public Set<Evse> getEvses() {
        return evses;
    }

    public void setEvses(Set<Evse> evses) {
        this.evses = evses;
    }

    public Map<String, String> getSettings() {
        return settings;
    }

    public void setSettings(Map<String, String> settings) {
        this.settings = settings;
    }
}
