package com.leafvillage.flightbookingapp.exceptions;

public class FlightFullException extends RuntimeException {
    private final static String prefix = "Flight is filled completely, No Seats Available";

    @Override
    public String getMessage() {
        return prefix;
    }
}
