package brad.tech.api.safaricom.daraja.v1.stk;

import java.util.Map;

public class LipaNaMpesaQueryRequest extends LipaNaMPesaOnlineRequestBase implements LipaNaMpesaOnlineResponseConstants {

    private String checkoutRequestID;

    public String getCheckoutRequestID() {
        return checkoutRequestID;
    }

    public void setCheckoutRequestID(String checkoutRequestID) {
        this.checkoutRequestID = checkoutRequestID;
    }

    @Override
    public Map<String, String> getKeyValuePair() {
        final Map<String, String> map = super.getKeyValuePair();
        map.put(CHECKOUT_REQUEST_ID, checkoutRequestID);
        return map;
    }
}
