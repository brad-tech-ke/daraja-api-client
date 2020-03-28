package brad.tech.api.safaricom.daraja.v1.stk;

import brad.tech.api.safaricom.daraja.MPesaException;

public class LipaNaMPesaOnlinePaymentAPIClient extends LipaNaMPesaOnlineAPIClientBase {

    public LipaNaMPesaOnlinePaymentAPIClient(String url) {
        super(url);
    }

    public LipaNaMPesaResponse transact(LipaNaMPesaPaymentRequest request) throws MPesaException {
        return this.executeLipaNaMPesaOnlineRequest(request);
    }
}
