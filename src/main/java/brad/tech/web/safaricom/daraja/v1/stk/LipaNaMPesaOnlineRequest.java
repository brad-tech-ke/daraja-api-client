package brad.tech.web.safaricom.daraja.v1.stk;

public class LipaNaMPesaOnlineRequest extends LipaNaMPesaRequestBase {

    private String checkoutRequestID;

    public String getCheckoutRequestID() {
        return checkoutRequestID;
    }

    public void setCheckoutRequestID(String checkoutRequestID) {
        this.checkoutRequestID = checkoutRequestID;
    }

    @Override
    public String toJson() {
        return String.format("{" +
                "\"BusinessShortCode\" : \"%s\", " +
                "\"Password\" : \"%s\", " +
                "\"Timestamp\" : \"%s\", " +
                "\"CheckoutRequestID\" : \"%s\" " +
                "}", businessShortCode, password, timestamp, checkoutRequestID
        );
    }
}
