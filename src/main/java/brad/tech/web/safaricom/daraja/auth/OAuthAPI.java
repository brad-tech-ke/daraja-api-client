package brad.tech.web.safaricom.daraja.auth;

import brad.tech.web.safaricom.daraja.DarajaAPIException;
import brad.tech.web.safaricom.daraja.ResourceBundleConsumer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Base64;

public class OAuthAPI implements ResourceBundleConsumer {

    private final String appKey, appSecret;
    private String url;
    private String characterEncoding = "ISO-8859-1";

    public OAuthAPI(String appKey, String appSecret) {
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.url = "https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials";
    }

    public String getAppKey() {
        return appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCharacterEncoding() {
        return characterEncoding;
    }

    public void setCharacterEncoding(String characterEncoding) {
        this.characterEncoding = characterEncoding;
    }

    /**
     * This authenticates with the Daraja API service.
     * <p>
     * This methods performs a GET request to the OAuth service and returns a wrapper
     * for the json payload returned.
     *
     * @return an {@link OAuthResponse} object.
     * @throws DarajaAPIException that wraps around {@link IOException}.
     */
    public OAuthResponse authenticate() throws DarajaAPIException {
        OAuthResponse oAuthResponse = null;

        final HttpGet request = new HttpGet(this.url);
        try (final CloseableHttpClient client = HttpClients.createDefault()) {
            byte[] bytes = String.format("%s:%s", appKey, appSecret).getBytes(characterEncoding);
            String auth = Base64.getEncoder().encodeToString(bytes);
            request.addHeader("Authorization", "Basic " + auth);
            request.addHeader("Cache-Control", "no-cache");

            HttpResponse response = client.execute(request);
            final HttpEntity entity = response.getEntity();
            if (entity != null) {
                String json = EntityUtils.toString(entity);
                ObjectMapper mapper = new ObjectMapper();
                oAuthResponse = mapper.readValue(json, OAuthResponse.class);
            }
        } catch (IOException ex) {
            final String errorMessage = il8n.getString("errorEstablishingLink");
            throw new DarajaAPIException(errorMessage.replace("#{service}", "OAuth"), ex);
        }

        return oAuthResponse;
    }
}
