package com.leafvillage.flightbookingapp.exceptions;

public class InvalidParameterTypeException extends RuntimeException{
    private final static String prefix = "Invalid Parameter: ";

    public InvalidParameterTypeException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return prefix + super.getMessage();
    }
}
