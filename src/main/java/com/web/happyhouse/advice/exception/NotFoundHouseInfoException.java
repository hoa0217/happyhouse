package com.web.happyhouse.advice.exception;

public class NotFoundHouseInfoException extends RuntimeException{
    public NotFoundHouseInfoException() {
        super();
    }

    public NotFoundHouseInfoException(String message) {
        super(message);
    }

    public NotFoundHouseInfoException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundHouseInfoException(Throwable cause) {
        super(cause);
    }
}
