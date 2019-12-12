package brad.tech.api.safaricom.daraja.v1.stk;

import brad.tech.api.safaricom.daraja.MPesaAPIBase;
import brad.tech.api.safaricom.daraja.MPesaException;
import org.apache.http.client.methods.HttpPost;

import java.io.IOException;
import java.util.HashMap;

public abstract class LipaNaMPesaOnlineAPIBase extends MPesaAPIBase {

    public LipaNaMPesaOnlineAPIBase(String url) {
        super(url);
    }

    // Lipa na MPesa
    protected LipaNaMPesaResponse executeLipaNaMPesaOnlineRequest(LipaNaMPesaRequestBase request) throws MPesaException {
        LipaNaMPesaResponse response = null;

        // build the headers
        final HttpPost httpPost = createBasicPostRequest();
        request.getKeyValuePair().forEach(httpPost::setHeader);

        try {
            HashMap map = getJsonMap(httpPost);
            if (map != null) {
                String merchantRequestID = (String) map.get("MerchantRequestID");
                String checkoutRequestID = (String) map.get("CheckoutRequestID");
                String responseCode = (String) map.get("ResponseCode");
                String resultDesc = (String) map.get("ResultDesc");
                String responseDescription = (String) map.get("ResponseDescription");
                String resultCode = (String) map.get("ResultCode");

                response = new LipaNaMPesaResponse();
                response.setMerchantRequestID(merchantRequestID);
                response.setCheckoutRequestID(checkoutRequestID);
                response.setResponseCode(responseCode);
                response.setResultDesc(resultDesc);
                response.setResponseDescription(responseDescription);
                response.setResultCode(resultCode);
            }
        } catch (IOException ex) {
            String il8nMessage = "" + il8n.getString("errorEstablishingLink");
            String message = il8nMessage.replace("#{service}", "Lipa na M-Pesa Online");
            throw new MPesaException(message, ex);
        }

        return response;
    }
}
