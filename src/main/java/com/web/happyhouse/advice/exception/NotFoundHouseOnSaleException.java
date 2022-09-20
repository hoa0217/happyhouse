package com.web.happyhouse.advice.exception;

public class NotFoundHouseOnSaleException extends RuntimeException{
    public NotFoundHouseOnSaleException() {
        super();
    }

    public NotFoundHouseOnSaleException(String message) {
        super(message);
    }

    public NotFoundHouseOnSaleException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundHouseOnSaleException(Throwable cause) {
        super(cause);
    }
}
