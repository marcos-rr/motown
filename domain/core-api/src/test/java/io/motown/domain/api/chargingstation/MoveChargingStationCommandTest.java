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

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import static io.motown.domain.api.chargingstation.test.ChargingStationTestUtils.*;

public class MoveChargingStationCommandTest {

    @Test(expected = NullPointerException.class)
    public void testMoveChargingStationCommandWithNullChargingStationId() {
        new MoveChargingStationCommand(null, COORDINATES, ADDRESS, ACCESSIBILITY, IDENTITY_CONTEXT);
    }

    @Test(expected = NullPointerException.class)
    public void testMoveChargingStationCommandWithNullCoordinatesAndAddress() {
        new MoveChargingStationCommand(CHARGING_STATION_ID, null, null, ACCESSIBILITY, IDENTITY_CONTEXT);
    }

    @Test(expected = NullPointerException.class)
    public void testMoveChargingStationCommandWithNullAccessibility() {
        new MoveChargingStationCommand(CHARGING_STATION_ID, COORDINATES, ADDRESS, null, IDENTITY_CONTEXT);
    }

    @Test(expected = NullPointerException.class)
    public void testMoveChargingStationCommandWithNullIdentityContext() {
        new MoveChargingStationCommand(CHARGING_STATION_ID, COORDINATES, ADDRESS, ACCESSIBILITY, null);
    }

    @Test
    public void equalsAndHashCodeShouldBeImplementedAccordingToTheContract() {
        EqualsVerifier.forClass(MoveChargingStationCommand.class).usingGetClass().verify();
    }
}
