package brad.tech.web.safaricom.daraja.v1.stk;

import brad.tech.web.safaricom.daraja.MPesaException;

public class LipaNaMPesaOnlinePaymentAPI extends LipaNaMPesaOnlineAPIBase {

    public LipaNaMPesaOnlinePaymentAPI(String url) {
        super(url);
    }

    public LipaNaMPesaResponse transact(LipaNaMPesaPaymentRequest request) throws MPesaException {
        return execute(request);
    }
}
