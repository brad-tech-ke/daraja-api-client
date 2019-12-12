package brad.tech.api.safaricom.daraja;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;

public abstract class MPesaAPIBase implements ResourceBundleConsumer {

    protected final String url;
    protected String accessToken;

    public MPesaAPIBase(String url) {
        this.url = url;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    // helper methods
    protected HttpPost createBasicPostRequest() throws MPesaException {
        final HttpPost httpPost = new HttpPost(this.url);
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Authorization", "Bearer " + this.accessToken);

        return httpPost;
    }

    protected HashMap getJsonMap(HttpUriRequest request) throws IOException, MPesaException {
        HashMap map;

        try (final CloseableHttpClient client = HttpClients.createDefault()) {
            final HttpResponse response = client.execute(request);

            int statusCode = response.getStatusLine().getStatusCode();
            String statusDesc = response.getStatusLine().getReasonPhrase();

            // check if the status is of the range 200 <= x < 300
            if (statusCode >= 200 && statusCode < 300) {
                String json = EntityUtils.toString(response.getEntity());
                map = new ObjectMapper().readValue(json, HashMap.class);
            } else {    // otherwise it is an error. throw an MPesaException
                String message = String.format("%s: %d - %s", il8n.getString("errorResponse"), statusCode, statusDesc);
                throw new MPesaException(message);
            }
        }

        return map;
    }


}
