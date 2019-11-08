package brad.tech.web.safaricom.daraja.auth;

import brad.tech.web.safaricom.daraja.MPesaException;
import brad.tech.web.safaricom.daraja.SandboxURLs;
import brad.tech.web.safaricom.daraja.v1.auth.OAuthAPI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OAuthAPITest {

    @Test
    public void testThrowsDarajaAPIExceptionWithFakeCredentials() {
        final OAuthAPI api = new OAuthAPI(SandboxURLs.OAUTH, "", "");
        assertThrows(MPesaException.class, api::authenticate);
    }
}
