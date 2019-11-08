/*
 * Copyright (c) 2019 BRAD Technologies and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, IS NOT permitted.

 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDER "AS IS" AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package brad.tech.web.safaricom.daraja;

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
