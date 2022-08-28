package com.web.happyhouse.exception;

public class DuplicatedUserException extends RuntimeException{
    public DuplicatedUserException() {
        super();
    }

    public DuplicatedUserException(String message) {
        super(message);
    }

    public DuplicatedUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicatedUserException(Throwable cause) {
        super(cause);
    }
}
