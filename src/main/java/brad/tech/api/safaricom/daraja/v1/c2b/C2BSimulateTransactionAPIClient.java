package brad.tech.api.safaricom.daraja.v1.c2b;

import brad.tech.api.safaricom.daraja.v1.MPesaStandardResponse;
import org.apache.http.client.methods.HttpPost;

public class C2BSimulateTransactionAPIClient extends C2BAPIClientBase {

    public C2BSimulateTransactionAPIClient(String url) {
        super(url);
    }

    public MPesaStandardResponse simulateTransaction(C2BSimulateTransactionRequest request) {
        final HttpPost httpPost = new HttpPost(this.url);
        request.getKeyValuePair().forEach(httpPost::setHeader);

        return executeC2BRequest(httpPost);
    }
}
