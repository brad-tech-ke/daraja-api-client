package brad.tech.web.safaricom.daraja.v1.auth;

import brad.tech.web.safaricom.daraja.MPesaAPIBase;
import brad.tech.web.safaricom.daraja.MPesaException;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;

public class OAuthAPI extends MPesaAPIBase {

    private String appKey, appSecret;

    /**
     * Creates an OAuthAPI object for authenticating apps.
     *
     * @param url       the OAuthAPI URL
     * @param appKey    the app key to authenticate against
     * @param appSecret the app secret that will be used to authenticate
     */
    public OAuthAPI(String url, String appKey, String appSecret) {
        super(url);

        this.appKey = appKey;
        this.appSecret = appSecret;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    /**
     * Generate an OAuth Response from the OAuth API.
     * <p>
     * This makes a GET request to the api service and returns an authentication
     * object.
     *
     * @return an {@link OAuthResponse} object or null.
     * @throws MPesaException that wraps around {@link IOException} exception.
     * @see IOException
     */
    public OAuthResponse authenticate() throws MPesaException {
        OAuthResponse oAuthResponse = null;

        // create the auth password
        final String appKey = this.getAppKey();
        final String appSecret = this.getAppSecret();

        final byte[] bytes = String.format("%s:%s", appKey, appSecret)
                .getBytes(StandardCharsets.ISO_8859_1);
        final String auth = Base64.getEncoder().encodeToString(bytes);

        final HttpGet request = new HttpGet(this.url);
        request.addHeader("Authorization", "Basic " + auth);
        request.addHeader("Cache-Control", "no-cache");

        try {
            HashMap map = getJsonMap(request);
            if (map != null) {
                String accessToken = (String) map.get("access_token");
                long expiresIn;
                try {
                    expiresIn = Long.parseLong((String) map.get("expires_in"));
                } catch (NumberFormatException ex) {
                    expiresIn = 3599L;
                }

                oAuthResponse = new OAuthResponse(accessToken, expiresIn);
            }
        } catch (IOException ex) {
            throw new MPesaException("Error establishing link to MPesa OAuth API Service", ex);
        }

        return oAuthResponse;
    }

}
