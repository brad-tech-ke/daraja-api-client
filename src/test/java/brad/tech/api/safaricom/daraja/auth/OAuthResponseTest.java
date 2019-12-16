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
package brad.tech.api.safaricom.daraja.auth;

import brad.tech.api.safaricom.daraja.MPesaException;
import brad.tech.api.safaricom.daraja.v1.auth.OAuthAPIClient;
import brad.tech.api.safaricom.daraja.v1.auth.OAuthResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OAuthResponseTest {

    private static OAuthAPIClient apiClient;

    @BeforeAll
    private static void init() {
        String consumerKeyEnv = System.getenv("MPESA_CONSUMER_KEY");
        String consumerSecretEnv = System.getenv("MPESA_CONSUMER_SECRET");

        String consumerKey = consumerKeyEnv == null ? "" : consumerKeyEnv;
        String consumerSecret = consumerSecretEnv == null ? "" : consumerSecretEnv;

        apiClient = new OAuthAPIClient(consumerKey, consumerSecret);
    }

    @Test
    public void whenAuthCalledShouldReturnValidOAuthObject() throws MPesaException {
        final OAuthResponse authResponse = apiClient.authenticate();
        assertNotNull(authResponse, "OAuth Response Should Return Valid Object");
    }
}
