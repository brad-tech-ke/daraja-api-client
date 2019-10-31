package brad.tech.web.safaricom.daraja.auth;

import brad.tech.web.safaricom.daraja.JsonSerializable;

/**
 * This class represents an authentication response object.
 * <p>
 * It has two properties: the access token and time to expire.
 *
 * @see <a href="https://developer.safaricom.co.ke/docs#authentication">Authentication Docs</a>
 * @see JsonSerializable
 */
public class OAuthResponse implements JsonSerializable {

    private String accessToken;
    private Long expiresIn;

    public OAuthResponse() {
    }

    /**
     * A convenience constructor.
     *
     * @param accessToken the access token representation
     * @param expiresIn the time the token expires in.
     */
    public OAuthResponse(String accessToken, long expiresIn) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Override
    public String toJson() {
        return String.format("{" +
                "\"access_token\" : \"%s\", " +
                "\"expires_in\" : \"%d\"" +
                "}", accessToken, expiresIn);
    }

    @Override
    public String toString() {
        return toJson();
    }
}
