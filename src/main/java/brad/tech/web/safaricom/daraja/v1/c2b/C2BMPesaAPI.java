package brad.tech.web.safaricom.daraja.v1.c2b;

import brad.tech.web.safaricom.daraja.MPesaAPIBase;

public abstract class C2BMPesaAPI extends MPesaAPIBase {

    /**
     * This cascades the url to the base class.
     *
     * @param url the C2B API url
     */
    public C2BMPesaAPI(String url) {
        super(url);
    }


}
