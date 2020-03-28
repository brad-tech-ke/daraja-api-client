package brad.tech.api.safaricom.daraja.v1.lnm;

import brad.tech.api.safaricom.daraja.MPesaAPIClientBase;
import brad.tech.api.safaricom.daraja.MPesaException;
import org.apache.http.client.methods.HttpPost;

import java.io.IOException;
import java.util.HashMap;

public class LipaNaMpesaOnlineAPI extends MPesaAPIClientBase implements LipaNaMpesaOnlineResponseConstants {

    public LipaNaMpesaOnlineAPI(String url) {
        super(url);
    }

    public LipaNaMpesaOnlineResponse execute(LipaNaMPesaOnlineRequestBase request) throws MPesaException {
        LipaNaMpesaOnlineResponse response = null;

        // build the headers
        final HttpPost httpPost = this.createBasicMPesaPostRequest();
        request.getKeyValuePair().forEach(httpPost::setHeader);

        try {
            final HashMap<String, Object> map = getJsonPayload(httpPost).getJsonMap();
            if (map != null) {
                String merchantRequestID = (String) map.get(MERCHANT_REQUEST_ID);
                String checkoutRequestID = (String) map.get(CHECKOUT_REQUEST_ID);
                String responseCode = (String) map.get(RESPONSE_CODE);
                String resultDesc = (String) map.get(RESULT_DESC);
                String responseDescription = (String) map.get(RESPONSE_DESCRIPTION);
                String resultCode = (String) map.get(RESULT_CODE);

                response = new LipaNaMpesaOnlineResponse();
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
