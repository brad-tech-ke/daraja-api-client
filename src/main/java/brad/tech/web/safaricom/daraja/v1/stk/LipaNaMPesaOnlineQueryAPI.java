package brad.tech.web.safaricom.daraja.v1.stk;

import brad.tech.web.safaricom.daraja.MPesaException;

public class LipaNaMPesaOnlineQueryAPI extends LipaNaMPesaOnlineAPIBase {

    public LipaNaMPesaOnlineQueryAPI(String url) {
        super(url);
    }

    public LipaNaMPesaResponse fetch(LipaNaMPesaQueryRequest request) throws MPesaException {
        return super.execute(request);
    }
}
