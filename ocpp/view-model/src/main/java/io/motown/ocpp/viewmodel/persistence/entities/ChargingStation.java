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
package io.motown.ocpp.viewmodel.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ChargingStation {
    @Id
    private String id;

    private String ipAddress;

    private boolean isRegistered = false;
    private boolean isConfigured = false;

    private int numberOfEvses;

    private ChargingStation() {
        // Private no-arg constructor for Hibernate.
    }

    public ChargingStation(String id) {
        this.id = id;
    }

    public ChargingStation(String id, String ipAddress) {
        this.id = id;
        this.ipAddress = ipAddress;
    }

    public String getId() {
        return id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public boolean isConfigured() {
        return isConfigured;
    }

    public boolean isRegisteredAndConfigured(){
        return (this.isRegistered() && this.isConfigured());
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    public void setConfigured(boolean configured) {
        this.isConfigured = configured;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getNumberOfEvses() {
        return numberOfEvses;
    }

    public void setNumberOfEvses(int numberOfEvses) {
        this.numberOfEvses = numberOfEvses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChargingStation that = (ChargingStation) o;

        if (isConfigured != that.isConfigured) return false;
        if (isRegistered != that.isRegistered) return false;
        if (numberOfEvses != that.numberOfEvses) return false;
        if (!id.equals(that.id)) return false;
        if (ipAddress != null ? !ipAddress.equals(that.ipAddress) : that.ipAddress != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (ipAddress != null ? ipAddress.hashCode() : 0);
        result = 31 * result + (isRegistered ? 1 : 0);
        result = 31 * result + (isConfigured ? 1 : 0);
        result = 31 * result + numberOfEvses;
        return result;
    }
}
