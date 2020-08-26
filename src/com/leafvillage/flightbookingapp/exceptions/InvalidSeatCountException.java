package com.leafvillage.flightbookingapp.exceptions;

public class InvalidSeatCountException extends RuntimeException {
    private final static String prefix = "Invalid Seat Count";

    public InvalidSeatCountException() {
    }

    @Override
    public String getMessage() {
        return prefix;
    }
}
