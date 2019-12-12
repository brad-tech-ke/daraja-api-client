package brad.tech.api.safaricom.daraja;

public interface SandboxURLs {

    // auth
    String OAUTH_URL = "https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials";

    // b2b
    String B2C_URL = "https://sandbox.safaricom.co.ke/mpesa/b2c/v1/paymentrequest",
            B2B_URL = "https://sandbox.safaricom.co.ke/mpesa/b2b/v1/paymentrequest";

    // c2b
    String C2B_REGISTER_URL_URL = "https://sandbox.safaricom.co.ke/mpesa/c2b/v1/registerurl",
            C2B_SIMULATE_TRANSACTION_URL = "https://sandbox.safaricom.co.ke/mpesa/c2b/v1/simulate";

    // etc
    String ACCOUNT_BALANCE_URL = "https://sandbox.safaricom.co.ke/mpesa/accountbalance/v1/query",
            TRANSACTION_STATUS_URL = "https://sandbox.safaricom.co.ke/mpesa/transactionstatus/v1/query",
            REVERSAL_URL = "https://sandbox.safaricom.co.ke/mpesa/reversal/v1/request";

    // stk push
    String LIPA_NA_MPESA_PAYMENT_URL = "https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest",
            LIPA_NA_MPESA_QUERY_URL = "https://sandbox.safaricom.co.ke/mpesa/stkpushquery/v1/query";
}
