package com.company;

public class CookieWithdrawalException extends Exception {

    public CookieWithdrawalException() {
    }

    public CookieWithdrawalException(String message) {
        super(message);
    }

    public CookieWithdrawalException(String message, Throwable cause) {
        super(message, cause);
    }

    public CookieWithdrawalException(Throwable cause) {
        super(cause);
    }

    public CookieWithdrawalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
