package brad.tech.web.safaricom.daraja.auth;

import brad.tech.web.safaricom.daraja.DarajaAPIException;
import brad.tech.web.safaricom.daraja.SandboxURLs;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OAuthAPITest {

    @Test
    public void testThrowsDarajaAPIExceptionWithFakeCredentials() {
        final OAuthAPI api = new OAuthAPI("testKey", "testSecret");
        api.setUrl(SandboxURLs.OAUTH);
        assertThrows(DarajaAPIException.class, api::authenticate);
    }
}
