package brad.tech.api.safaricom.daraja.v1.stk;

import brad.tech.api.safaricom.daraja.MPesaException;

public class LipaNaMPesaOnlineQueryAPIClient extends LipaNaMPesaOnlineAPIClientBase {

    public LipaNaMPesaOnlineQueryAPIClient(String url) {
        super(url);
    }

    public LipaNaMPesaResponse query(LipaNaMPesaQueryRequest request) throws MPesaException {
        return super.executeLipaNaMPesaOnlineRequest(request);
    }
}
