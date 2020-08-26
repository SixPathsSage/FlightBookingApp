package com.leafvillage.flightbookingapp.model;

import java.util.ArrayList;
import java.util.List;

public class Flight {
    private List<Seat> seats;

    public Flight() {
        seats = new ArrayList<>();
    }

    public List<Seat> getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Flight{");
        sb.append("seats=").append(seats);
        sb.append('}');
        return sb.toString();
    }
}
