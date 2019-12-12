package brad.tech.api.safaricom.daraja.v1.stk;

import brad.tech.api.safaricom.daraja.CommandID;

import java.util.HashMap;
import java.util.Map;

public class LipaNaMPesaPaymentRequest extends LipaNaMPesaRequestBase {

    private Double amount;
    private String partyA, partyB;
    private String phoneNumber, callBackURL, accountReference, transactionDesc;

    public String getTransactionType() {
        return CommandID.CUSTOMER_PAY_BILL_ONLINE.getCommand();
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPartyA() {
        return partyA;
    }

    public void setPartyA(String partyA) {
        this.partyA = partyA;
    }

    public String getPartyB() {
        return partyB;
    }

    public void setPartyB(String partyB) {
        this.partyB = partyB;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCallBackURL() {
        return callBackURL;
    }

    public void setCallBackURL(String callBackURL) {
        this.callBackURL = callBackURL;
    }

    public String getAccountReference() {
        return accountReference;
    }

    public void setAccountReference(String accountReference) {
        this.accountReference = accountReference;
    }

    public String getTransactionDesc() {
        return transactionDesc;
    }

    public void setTransactionDesc(String transactionDesc) {
        this.transactionDesc = transactionDesc;
    }

    @Override
    public Map<String, String> getKeyValuePair() {
        Map<String, String> map = super.getKeyValuePair();
        map.putAll(
                // specific to this class
                new HashMap<String, String>() {{
                    put("Amount", amount + "");
                    put("PartyA", partyA);
                    put("PartyB", partyB);
                    put("PhoneNumber", phoneNumber);
                    put("CallbackURL", callBackURL);
                    put("AccountReference", accountReference);
                    put("TransactionDesc", transactionDesc);
                    put("TransactionType", getTransactionType());
                }}
        );
        return map;
    }
}
