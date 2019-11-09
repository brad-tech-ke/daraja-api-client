package brad.tech.web.safaricom.daraja.v1.c2b;

import brad.tech.web.safaricom.daraja.MPesaException;
import brad.tech.web.safaricom.daraja.v1.MPesaStandardResponse;
import org.apache.http.client.methods.HttpPost;

public class C2BRegisterURLAPI extends C2BAPIBase {

    public C2BRegisterURLAPI(String url) {
        super(url);
    }

    public MPesaStandardResponse register(C2BRegisterURLRequest request) throws MPesaException {
        final HttpPost httpPost = new HttpPost(this.url);
        request.getKeyValuePair().forEach(httpPost::setHeader);

        return executeC2BRequest(httpPost);
    }
}
