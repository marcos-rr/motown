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

import org.junit.Test;

import java.util.HashMap;

import static io.motown.domain.api.chargingstation.test.ChargingStationTestUtils.*;

public class BootChargingStationCommandTest {

    @Test(expected = NullPointerException.class)
    public void nullPointerExceptionThrownWhenCreatingChargingStationWithChargingStationIdNull() {
        new BootChargingStationCommand(null, PROTOCOL, IDENTITY_CONTEXT);
    }

    @Test(expected = NullPointerException.class)
    public void nullPointerExceptionThrownWhenCreatingChargingStationWithChargingStationIdNullAndAttributes() {
        new BootChargingStationCommand(null, PROTOCOL, new HashMap<String, String>(), IDENTITY_CONTEXT);
    }

    @Test(expected = NullPointerException.class)
    public void nullPointerExceptionThrownWhenCreatingChargingStationWithChargingStationIdAndAttributesNull() {
        new BootChargingStationCommand(CHARGING_STATION_ID, null, IDENTITY_CONTEXT);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void unsupportedOperationExceptionThrownWhenModifyingAttributes() {
        BootChargingStationCommand command = new BootChargingStationCommand(CHARGING_STATION_ID, PROTOCOL, BOOT_NOTIFICATION_ATTRIBUTES, IDENTITY_CONTEXT);

        command.getAttributes().put("foo", "bar");
    }
}
