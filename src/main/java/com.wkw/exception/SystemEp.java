package com.wkw.exception;

/**
 * create by wkw
 */
public class SystemEp extends RuntimeException {
    public SystemEp(String message) {
        super(message);
    }

    public SystemEp(String message, Throwable cause) {
        super(message, cause);
    }


}
