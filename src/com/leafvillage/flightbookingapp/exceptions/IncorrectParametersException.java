package com.leafvillage.flightbookingapp.exceptions;

public class IncorrectParametersException extends RuntimeException{
    private final static String prefix = "Incorrect Parameter: ";
    public IncorrectParametersException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return prefix + super.getMessage();
    }
}
