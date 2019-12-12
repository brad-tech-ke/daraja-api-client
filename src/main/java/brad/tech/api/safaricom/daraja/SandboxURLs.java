package brad.tech.api.safaricom.daraja;

public interface SandboxURLs {

    // auth
    String OAUTH = "https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials";

    // b2b
    String B2C = "https://sandbox.safaricom.co.ke/mpesa/b2c/v1/paymentrequest",
            B2B = "https://sandbox.safaricom.co.ke/mpesa/b2b/v1/paymentrequest";

    // c2b
    String C2B_REGISTER_URL_API = "https://sandbox.safaricom.co.ke/mpesa/c2b/v1/registerurl",
            C2B_SIMULATE_TRANSACTION = "https://sandbox.safaricom.co.ke/mpesa/c2b/v1/simulate";

    // etc
    String ACCOUNT_BALANCE = "https://sandbox.safaricom.co.ke/mpesa/accountbalance/v1/query",
            TRANSACTION_STATUS = "https://sandbox.safaricom.co.ke/mpesa/transactionstatus/v1/query",
            REVERSAL = "https://sandbox.safaricom.co.ke/mpesa/reversal/v1/request";

    // stk push
    String LIPA_NA_MPESA_PAYMENT = "https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest",
            LIPA_NA_MPESA_QUERY = "https://sandbox.safaricom.co.ke/mpesa/stkpushquery/v1/query";
}
