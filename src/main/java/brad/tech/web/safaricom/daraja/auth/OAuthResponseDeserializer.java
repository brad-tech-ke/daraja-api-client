package brad.tech.web.safaricom.daraja.auth;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

/**
 * This class provides json deserialization for {@link OAuthResponse} objects.
 * <p>
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
