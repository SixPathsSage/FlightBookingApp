package com.leafvillage.flightbookingapp.exceptions;

public class InvalidCommandException extends RuntimeException {
    private final static String prefix = "Invalid Command: ";

    public InvalidCommandException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return prefix + super.getMessage();
    }
}
