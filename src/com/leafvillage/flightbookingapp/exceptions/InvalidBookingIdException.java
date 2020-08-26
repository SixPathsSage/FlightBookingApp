package com.leafvillage.flightbookingapp.exceptions;

public class InvalidBookingIdException extends RuntimeException{
    private final static String prefix = "Invalid BookingId: ";

    public InvalidBookingIdException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return prefix + super.getMessage();
    }
}
