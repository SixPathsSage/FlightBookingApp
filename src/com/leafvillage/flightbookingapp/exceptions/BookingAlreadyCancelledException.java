package com.leafvillage.flightbookingapp.exceptions;

public class BookingAlreadyCancelledException extends RuntimeException{
    private final static String prefix = "Booking Already Cancelled for BookingId: ";

    public BookingAlreadyCancelledException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return prefix + super.getMessage();
    }
}
