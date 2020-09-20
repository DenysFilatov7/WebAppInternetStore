package com.epam.dfilatov.istore.exception;

public class ValidationException extends IllegalArgumentException{

    private static final long serialVersionUID = 1936982345728678928L;

    public ValidationException(String s) {
        super(s);
    }
}
