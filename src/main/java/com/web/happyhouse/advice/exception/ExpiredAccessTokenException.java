package com.web.happyhouse.advice.exception;

public class ExpiredAccessTokenException extends RuntimeException{
    public ExpiredAccessTokenException() {
        super();
    }

    public ExpiredAccessTokenException(String message) {
        super(message);
    }

    public ExpiredAccessTokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExpiredAccessTokenException(Throwable cause) {
        super(cause);
    }
}
