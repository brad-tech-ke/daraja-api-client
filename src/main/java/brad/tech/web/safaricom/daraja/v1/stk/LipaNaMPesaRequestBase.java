package brad.tech.web.safaricom.daraja.v1.stk;

import brad.tech.web.safaricom.daraja.JsonSerializable;

public abstract class LipaNaMPesaRequestBase implements JsonSerializable {

    protected String businessShortCode, password, timestamp;

    public String getBusinessShortCode() {
        return businessShortCode;
    }

    public void setBusinessShortCode(String businessShortCode) {
        this.businessShortCode = businessShortCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
