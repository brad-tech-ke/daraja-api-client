package brad.tech.web.safaricom.daraja.v1.stk;

import java.util.Map;

public class LipaNaMPesaQueryRequest extends LipaNaMPesaRequestBase {

    private String checkoutRequestID;

    public String getCheckoutRequestID() {
        return checkoutRequestID;
    }

    public void setCheckoutRequestID(String checkoutRequestID) {
        this.checkoutRequestID = checkoutRequestID;
    }

    @Override
    public Map<String, String> getKeyValuePair() {
        Map<String, String> map = super.getKeyValuePair();
        map.put("CheckoutRequestID", checkoutRequestID);
        return map;
    }
}
