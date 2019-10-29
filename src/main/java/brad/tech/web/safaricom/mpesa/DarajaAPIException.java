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
package brad.tech.web.safaricom.mpesa;

/**
 * This exception class is a simple wrapper for exceptions thrown by connections.
 * <p>
 * This will be available for most exceptions that will likely be thrown by the REST api.
 * The only requirement is for the user to provide a message at the very least.
 * <p>
 * NOTE: It is NOT extensible.
 */
public final class DarajaAPIException extends Exception {

    /**
     * A simple constructor with a message.
     * <p>
     * This satisfies the condition that a message should be supplied.
     *
     * @param message the message explaining the exception.
     */
    public DarajaAPIException(String message) {
        super(message);
    }

    /**
     * A constructor that provides a message and a reference to the cause.
     * <p>
     * This provides wrapper functionality for any exception thrown by the APIs.
     *
     * @param message The message describing the exception.
     * @param cause The root cause of the exception.
     */
    public DarajaAPIException(String message, Throwable cause) {
        super(message, cause);
    }
}
