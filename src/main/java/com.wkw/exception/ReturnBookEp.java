package com.wkw.exception;

/**
 * create by wkw
 */
public class ReturnBookEp extends RuntimeException {
    public ReturnBookEp(String message) {
        super(message);
    }

    public ReturnBookEp(String message, Throwable cause) {
        super(message, cause);
    }
}
