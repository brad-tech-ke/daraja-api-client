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

    private String access_token;
    private Long expires_in;

    public OAuthResponse() {
    }

    /**
     * A convenience constructor.
     *
     * @param access_token the access token representation
     * @param expires_in the time the token expires in.
     */
    public OAuthResponse(String access_token, long expires_in) {
        this.access_token = access_token;
        this.expires_in = expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
    }

    @Override
    public String toJson() {
        return String.format("{" +
                "\"access_token\" : \"%s\", " +
                "\"expires_in\" : \"%d\"" +
                "}", access_token, expires_in);
    }

    @Override
    public String toString() {
        return toJson();
    }
}
