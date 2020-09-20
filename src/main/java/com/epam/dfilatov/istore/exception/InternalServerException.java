package com.epam.dfilatov.istore.exception;

public class InternalServerException extends RuntimeException {

    private static final long serialVersionUID = -5512229268651958732L;

    public InternalServerException(String message) {
        super(message);
    }

    public InternalServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public InternalServerException(Throwable cause) {
        super(cause);
    }
}
