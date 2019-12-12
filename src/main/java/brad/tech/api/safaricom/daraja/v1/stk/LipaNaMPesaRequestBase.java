package brad.tech.api.safaricom.daraja.v1.stk;

import brad.tech.api.safaricom.daraja.KeyValuePair;

import java.util.HashMap;
import java.util.Map;

public abstract class LipaNaMPesaRequestBase implements KeyValuePair {

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

    @Override
    public Map<String, String> getKeyValuePair() {
        return new HashMap<String, String>() {{
            put("BusinessShortCode", businessShortCode);
            put("Password", password);
            put("Timestamp", timestamp);
        }};
    }
}
