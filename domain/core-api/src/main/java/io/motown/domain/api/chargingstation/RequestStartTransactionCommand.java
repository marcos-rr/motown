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
package io.motown.domain.api.chargingstation;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * {@code RequestStartTransactionCommand} is the command which is published when a transaction should be started.
 */
public final class RequestStartTransactionCommand {

    @TargetAggregateIdentifier
    private final ChargingStationId chargingStationId;

    private final IdentifyingToken identifyingToken;

    private final EvseId evseId;

    /**
     * Creates a {@code RequestStopTransactionCommand} with an identifier and a identifying token.
     *
     * @param chargingStationId the identifier of the charging station.
     * @param identifyingToken  the token that should start the transaction.
     * @param evseId            the identifier of the evse.
     * @throws NullPointerException if {@code chargingStationId}, {@code identifyingToken} or {@code evseId} is {@code null}.
     */
    public RequestStartTransactionCommand(ChargingStationId chargingStationId, IdentifyingToken identifyingToken, EvseId evseId) {
        this.chargingStationId = checkNotNull(chargingStationId);
        this.identifyingToken = checkNotNull(identifyingToken);
        this.evseId = checkNotNull(evseId);
    }

    /**
     * Gets the charging station identifier.
     *
     * @return the charging station identifier.
     */
    public ChargingStationId getChargingStationId() {
        return chargingStationId;
    }

    /**
     * Gets the token which should start the transaction.
     *
     * @return the token.
     */
    public IdentifyingToken getIdentifyingToken() {
        return identifyingToken;
    }

    /**
     * Gets the evse id.
     *
     * @return the evse id.
     */
    public EvseId getEvseId() {
        return evseId;
    }
}
