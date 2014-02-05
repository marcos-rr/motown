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
package io.motown.operatorapi.json.commands;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.motown.domain.api.chargingstation.ChargingStationId;
import io.motown.domain.api.chargingstation.RequestStartTransactionCommand;
import io.motown.operatorapi.viewmodel.model.RequestStartTransactionApiCommand;
import io.motown.operatorapi.viewmodel.persistence.entities.ChargingStation;
import io.motown.operatorapi.viewmodel.persistence.repositories.ChargingStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
class RequestStartTransactionJsonCommandHandler implements JsonCommandHandler {

    private static final String COMMAND_NAME = "RequestStartTransaction";

    private DomainCommandGateway commandGateway;

    private ChargingStationRepository repository;

    private Gson gson;

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void handle(String chargingStationId, JsonObject commandObject) {
        try {
            ChargingStation chargingStation = repository.findOne(chargingStationId);
            if (chargingStation != null && chargingStation.isAccepted()) {
                RequestStartTransactionApiCommand command = gson.fromJson(commandObject, RequestStartTransactionApiCommand.class);

                commandGateway.send(new RequestStartTransactionCommand(new ChargingStationId(chargingStationId), command.getIdentifyingToken(), command.getEvseId()));
            } else {
                throw new IllegalStateException("It is not possible to request a start transaction on a charging station that is not registered");
            }
        } catch (ClassCastException ex) {
            throw new IllegalArgumentException("Start transaction command is not able to parse the payload, is your json correctly formatted?", ex);
        }
    }

    @Resource(name = "domainCommandGateway")
    public void setCommandGateway(DomainCommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Autowired
    public void setRepository(ChargingStationRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setGson(Gson gson) {
        this.gson = gson;
    }
}
