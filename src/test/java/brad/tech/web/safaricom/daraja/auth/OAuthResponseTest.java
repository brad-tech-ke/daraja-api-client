package brad.tech.web.safaricom.daraja.auth;

import brad.tech.web.safaricom.daraja.JsonSerializable;
import brad.tech.web.safaricom.daraja.v1.auth.OAuthResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OAuthResponseTest {

    @Test
    public void testToJsonShouldReturnValidJsonString() {
        String json = "{\"access_token\" : \"THIS_IS_A_TEST\", \"expires_in\" : \"3599\"}";
        JsonSerializable response = new OAuthResponse("THIS_IS_A_TEST", 3599);

        assertEquals(json, response.toJson(), "OAuthResponse#toJson() should return actual string");
    }
}
