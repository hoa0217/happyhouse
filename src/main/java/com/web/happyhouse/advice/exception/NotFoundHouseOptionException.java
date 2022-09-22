package com.web.happyhouse.advice.exception;

public class NotFoundHouseOptionException extends RuntimeException{
    public NotFoundHouseOptionException() {
        super();
    }

    public NotFoundHouseOptionException(String message) {
        super(message);
    }

    public NotFoundHouseOptionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundHouseOptionException(Throwable cause) {
        super(cause);
    }
}
