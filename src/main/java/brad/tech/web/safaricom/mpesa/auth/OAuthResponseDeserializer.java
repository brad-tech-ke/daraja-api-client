/*
 * Copyright (c) 2019 BRAD Technologies and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, IS NOT permitted.

 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDER "AS IS" AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package brad.tech.web.safaricom.mpesa.auth;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

/**
 * This class provides json deserialization for {@link OAuthResponse} objects.
 *
 * This will parse the default response from the auth api.
 */
public class OAuthResponseDeserializer extends StdDeserializer<OAuthResponse> {

    public String accessTokenKey;
    public String expiresInKey;

    public OAuthResponseDeserializer() {
        super(OAuthResponse.class);

        accessTokenKey = "access_token";
        expiresInKey = "expires_in";
    }

    @Override
    public OAuthResponse deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        final JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String accessToken = node.get(accessTokenKey).asText();
        long expiresIn = node.get(expiresInKey).asLong();

        return new OAuthResponse(accessToken, expiresIn);
    }
}
