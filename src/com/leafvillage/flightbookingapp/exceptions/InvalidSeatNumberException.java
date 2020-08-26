package com.leafvillage.flightbookingapp.exceptions;

public class InvalidSeatNumberException extends RuntimeException{
    private final static String prefix = "Invalid Seat Number: ";
    public InvalidSeatNumberException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return prefix + super.getMessage();
    }
}
