package brad.tech.api.safaricom.daraja.v1.stk;

import brad.tech.api.safaricom.daraja.MPesaException;

public class LipaNaMPesaOnlinePaymentAPI extends LipaNaMPesaOnlineAPIBase {

    public LipaNaMPesaOnlinePaymentAPI(String url) {
        super(url);
    }

    public LipaNaMPesaResponse transact(LipaNaMPesaPaymentRequest request) throws MPesaException {
        return executeLipaNaMPesaOnlineRequest(request);
    }
}