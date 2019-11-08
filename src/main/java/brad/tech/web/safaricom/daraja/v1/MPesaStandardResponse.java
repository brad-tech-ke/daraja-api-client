package brad.tech.web.safaricom.daraja.v1;

import brad.tech.web.safaricom.daraja.JsonSerializable;

public class MPesaStandardResponse implements JsonSerializable {

    private String conversationID, originatorConversationID, responseDescription;

    public MPesaStandardResponse() {
    }

    public MPesaStandardResponse(String conversationID, String originatorConversationID, String responseDescription) {
        this.conversationID = conversationID;
        this.originatorConversationID = originatorConversationID;
        this.responseDescription = responseDescription;
    }

    public String getConversationID() {
        return conversationID;
    }

    public void setConversationID(String conversationID) {
        this.conversationID = conversationID;
    }

    public String getOriginatorConversationID() {
        return originatorConversationID;
    }

    public void setOriginatorConversationID(String originatorConversationID) {
        this.originatorConversationID = originatorConversationID;
    }

    public String getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

    @Override
    public String toJson() {
        return String.format("{" +
                        "\"ConversationID\" : \"%s\", " +
                        "\"OriginatorConversationID\" : \"%s\", " +
                        "\"ResponseDescription\" : \"%s\"" +
                        "}",
                conversationID, originatorConversationID, responseDescription
        );
    }
}
