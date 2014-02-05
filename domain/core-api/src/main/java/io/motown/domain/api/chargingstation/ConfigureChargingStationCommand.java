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

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * {@code ConfigureChargingStationCommand} is the command which is published when a charging station should be
 * configured.
 */
public final class ConfigureChargingStationCommand {

    @TargetAggregateIdentifier
    private final ChargingStationId chargingStationId;

    private final Set<Evse> evses;

    private final Map<String, String> settings;

    /**
     * Creates a {@code ConfigureChargingStationCommand} with an identifier.
     *
     * @param chargingStationId the identifier of the charging station.
     * @param evses        the evses with which the charging station should be configured.
     * @throws NullPointerException if {@code chargingStationId} is {@code null}.
     */
    public ConfigureChargingStationCommand(ChargingStationId chargingStationId, Set<Evse> evses) {
        this(chargingStationId, evses, Collections.<String, String>emptyMap());
    }

    /**
     * Creates a {@code ConfigureChargingStationCommand} with an identifier.
     *
     * @param chargingStationId the identifier of the charging station.
     * @param settings the settings with which the charging station should be configured.
     * @throws NullPointerException if {@code chargingStationId} is {@code null}.
     */
    public ConfigureChargingStationCommand(ChargingStationId chargingStationId, Map<String, String> settings) {
        this(chargingStationId, Collections.<Evse>emptySet(), settings);
    }

    /**
     * Creates a {@code ConfigureChargingStationCommand} with an identifier.
     *
     * @param chargingStationId the identifier of the charging station.
     * @param evses the evses with which the charging station should be configured.
     * @param settings the settings with which the charging station should be configured.
     * @throws NullPointerException if {@code chargingStationId}, {@code evses}, or {@code settings} is
     * {@code null}.
     */
    public ConfigureChargingStationCommand(ChargingStationId chargingStationId, Set<Evse> evses, Map<String, String> settings) {
        this.chargingStationId = checkNotNull(chargingStationId);
        this.evses = ImmutableSet.copyOf(checkNotNull(evses));
        this.settings = ImmutableMap.copyOf(checkNotNull(settings));
    }

    /**
     * Gets the charging station identifier.
     *
     * @return the charging station identifier.
     */
    public ChargingStationId getChargingStationId() {
        return this.chargingStationId;
    }

    /**
     * Gets the evses with which the charging station should be configured.
     *
     * @return an immutable {@link java.util.Set} of evses.
     */
    public Set<Evse> getEvses() {
        return evses;
    }

    /**
     * Gets the configuration items with which the charging station should be configured.
     *
     * These configuration items are additional information provided with which the charging station should be
     * configured but which are not required by Motown.
     *
     * @return an immutable {@link java.util.Map} of configuration items.
     */
    public Map<String, String> getSettings() {
        return settings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConfigureChargingStationCommand that = (ConfigureChargingStationCommand) o;

        if (!chargingStationId.equals(that.chargingStationId)) return false;
        if (!evses.equals(that.evses)) return false;
        if (!settings.equals(that.settings)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = chargingStationId.hashCode();
        result = 31 * result + evses.hashCode();
        result = 31 * result + settings.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this.getClass())
                .add("chargingStationId", chargingStationId)
                .add("evses", evses)
                .add("settings", settings)
                .toString();
    }
}
