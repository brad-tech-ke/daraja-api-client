package brad.tech.api.safaricom.daraja.v1.c2b;

import brad.tech.api.safaricom.daraja.MPesaAPIClientBase;
import brad.tech.api.safaricom.daraja.MPesaException;
import brad.tech.api.safaricom.daraja.v1.MPesaStandardResponse;
import org.apache.http.client.methods.HttpPost;

import java.io.IOException;
import java.util.HashMap;

public abstract class C2BAPIClientBase extends MPesaAPIClientBase {

    /**
     * This cascades the url to the base class.
     *
     * @param url the C2B API url
     */
    public C2BAPIClientBase(String url) {
        super(url);
    }

    protected MPesaStandardResponse executeC2BRequest(HttpPost httpPost) throws MPesaException {
        MPesaStandardResponse response = null;

        try {
            HashMap map = getJsonMap(httpPost);
            if (map != null) {
                String conversationID = (String) map.get("ConversationID");
                String originatorConversationID = (String) map.get("OriginatorConversationID");
                String responseDesc = (String) map.get("ResponseDescription");

                response = new MPesaStandardResponse(conversationID, originatorConversationID, responseDesc);
            }
        } catch (IOException ex) {
            throw new MPesaException("Error executing C2B Request", ex);
        }

        return response;
    }
}
