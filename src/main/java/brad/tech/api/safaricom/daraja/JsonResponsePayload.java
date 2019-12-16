package brad.tech.api.safaricom.daraja;

import java.util.HashMap;
import java.util.Map;

public class JsonResponsePayload {

    private int statusCode;
    private String statusMessage;
    private final Map<String, String> headerMap;
    private HashMap jsonMap;

    public JsonResponsePayload() {
        this.headerMap = new HashMap<>();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Map<String, String> getHeaderMap() {
        return headerMap;
    }

    public HashMap getJsonMap() {
        return jsonMap;
    }

    public void setJsonMap(HashMap jsonMap) {
        this.jsonMap = jsonMap;
    }
}
