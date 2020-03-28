/*
 * Copyright (c) 2020 BRAD Technologies and/or its affiliates.
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
package brad.tech.api.safaricom.daraja.v1.stk;

public interface LipaNaMpesaOnlineRequestConstants {

    /**
     * The organization short code used to receive the transaction.
     */
    String BUSINESS_SHORT_CODE = "BusinessShortCode";

    /**
     * The password encrypting the request. This is generated by base64 encoding BusinessShortCode, PassKey, and Timestamp
     */
    String PASSWORD = "Password";

    /**
     * The timestamp in the format 'yymmmddhhiiss'.
     */
    String TIMESTAMP = "Timestamp";

    /**
     * The transaction type to be used for this request. Only CustomerPayBillOnline is supported.
     *
     * @see brad.tech.api.safaricom.daraja.CommandID#CUSTOMER_PAY_BILL_ONLINE
     */
    String TRANSACTION_TYPE = "TransactionType";

    /**
     * The amount to be transacted.
     */
    String AMOUNT = "Amount";

    /**
     * The MSISDN sending the funds.
     */
    String PARTY_A = "PartyA";

    /**
     * The organization shortcode receiving the funds.
     */
    String PARTY_B = "PartyB";

    /**
     * The MSISDN sending the funds.
     */
    String PHONE_NUMBER = "PhoneNumber";

    /**
     * The url to where responses from M-Pesa will be sent to.
     */
    String CALLBACK_URL = "CallBackURL";

    /**
     * Used with M-Pesa PayBills.
     */
    String ACCOUNT_REFERENCE = "AccountReference";

    /**
     * A description of the transaction.
     */
    String TRANSACTION_DESC = "TransactionDesc";

    /**
     * Checkout RequestID
     */
    String CHECKOUT_REQUEST_ID = "CheckoutRequestId";
}
