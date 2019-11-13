package brad.tech.web.safaricom.daraja.v1.c2b;

import brad.tech.web.safaricom.daraja.CommandID;
import brad.tech.web.safaricom.daraja.KeyValuePair;

import java.util.HashMap;
import java.util.Map;

public class C2BSimulateTransactionRequest implements KeyValuePair {

    private CommandID commandID;
    private Double amount;
    private String msisdn, billRefNumber, shortCode;

    public CommandID getCommandID() {
        return commandID;
    }

    public void setCommandID(CommandID commandID) {
        this.commandID = commandID;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getBillRefNumber() {
        return billRefNumber;
    }

    public void setBillRefNumber(String billRefNumber) {
        this.billRefNumber = billRefNumber;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    @Override
    public Map<String, String> getKeyValuePair() {
        return new HashMap<String, String>() {{
            put("CommandID", commandID.getCommand());
            put("Amount", amount + "");
            put("MSISDN", msisdn);
            put("BillRefNumber", billRefNumber);
            put("ShortCode", shortCode);
        }};
    }
}
