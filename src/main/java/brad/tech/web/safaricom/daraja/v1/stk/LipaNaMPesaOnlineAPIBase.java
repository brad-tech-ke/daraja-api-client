package brad.tech.web.safaricom.daraja.v1.stk;

import brad.tech.web.safaricom.daraja.MPesaAPIBase;
import brad.tech.web.safaricom.daraja.MPesaException;
import org.apache.http.client.methods.HttpPost;

import java.io.IOException;
import java.util.HashMap;

public abstract class LipaNaMPesaOnlineAPIBase extends MPesaAPIBase {

    public LipaNaMPesaOnlineAPIBase(String url) {
        super(url);
    }

    // Lipa na MPesa
    protected LipaNaMPesaResponse execute(LipaNaMPesaRequestBase request) throws MPesaException {
        LipaNaMPesaResponse response = null;

        // build the headers
        final HttpPost httpPost = createBasicPostRequest();
        httpPost.setHeader("BusinessShortCode", request.getBusinessShortCode());
        httpPost.setHeader("Password", request.getPassword());
        httpPost.setHeader("Timestamp", request.getTimestamp());

        // LipaNaMPesaPaymentRequest
        if (request instanceof LipaNaMPesaPaymentRequest) {
            LipaNaMPesaPaymentRequest paymentRequest = (LipaNaMPesaPaymentRequest) request;
            httpPost.setHeader("Amount", paymentRequest.getAmount() + "");
            httpPost.setHeader("TransactionType", paymentRequest.getTransactionType());
            httpPost.setHeader("PartyA", paymentRequest.getPartyA());
            httpPost.setHeader("PartyB", paymentRequest.getPartyB());
            httpPost.setHeader("PhoneNumber", paymentRequest.getPhoneNumber());
            httpPost.setHeader("CallBackURL", paymentRequest.getCallBackURL());
            httpPost.setHeader("AccountReference", paymentRequest.getAccountReference());
            httpPost.setHeader("TransactionDesc", paymentRequest.getTransactionDesc());
        }

        // LipaNaMPesaOnlineRequest
        if (request instanceof LipaNaMPesaOnlineRequest) {
            LipaNaMPesaOnlineRequest queryRequest = (LipaNaMPesaOnlineRequest) request;
            httpPost.setHeader("TransactionDesc", queryRequest.getCheckoutRequestID());
        }

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
