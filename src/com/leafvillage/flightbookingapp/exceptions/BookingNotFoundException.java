package com.leafvillage.flightbookingapp.exceptions;

public class BookingNotFoundException extends RuntimeException{
    private final static String prefix = "Booking Not Found for BookingId: ";

    public BookingNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return prefix + super.getMessage();
    }
}
