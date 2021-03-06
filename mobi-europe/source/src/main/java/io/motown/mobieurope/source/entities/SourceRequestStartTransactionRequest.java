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
package io.motown.mobieurope.source.entities;

import com.google.common.base.Objects;
import io.motown.mobieurope.destination.soap.schema.RequestStartTransactionRequest;

import java.util.UUID;

public class SourceRequestStartTransactionRequest extends SourceRequest {

    private String authorizationIdentifier; // Generated by destination

    private String requestIdentifier;       // Generated by source

    public SourceRequestStartTransactionRequest() {
        this.requestIdentifier = UUID.randomUUID().toString();
    }

    public RequestStartTransactionRequest getRequestStartTransactionRequest() {
        RequestStartTransactionRequest requestStartTransactionRequest = new RequestStartTransactionRequest();
        requestStartTransactionRequest.setAuthorizationIdentifier(this.authorizationIdentifier);
        requestStartTransactionRequest.setRequestIdentifier(this.requestIdentifier);
        return requestStartTransactionRequest;
    }

    public String getAuthorizationIdentifier() {
        return authorizationIdentifier;
    }

    public void setAuthorizationIdentifier(String authorizationIdentifier) {
        this.authorizationIdentifier = authorizationIdentifier;
    }

    public String getRequestIdentifier() {
        return requestIdentifier;
    }

    public boolean isValid() {
        return !empty(authorizationIdentifier) && !empty(authorizationIdentifier);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("authorizationIdentifier", authorizationIdentifier)
                .add("requestIdentifier", requestIdentifier)
                .toString();
    }
}
