package com.leafvillage.flightbookingapp.strategy;

import com.leafvillage.flightbookingapp.exceptions.FlightFullException;
import com.leafvillage.flightbookingapp.model.Seat;
import com.leafvillage.flightbookingapp.model.SeatType;

import java.util.NoSuchElementException;
import java.util.TreeSet;

public class NaturalOrderAllocationStrategy implements AllocationStrategy {
    private TreeSet<Seat> economySeat;
    private TreeSet<Seat> businessSeat;

    public NaturalOrderAllocationStrategy() {
        this.economySeat = new TreeSet<>();
        this.businessSeat = new TreeSet<>();
    }

    @Override
    public void addSeat(Seat seat) {
        if(seat.getType() == SeatType.ECONOMY) {
            economySeat.add(seat);
        }
        else if(seat.getType() == SeatType.BUSINESS) {
            businessSeat.add(seat);
        }
    }

    @Override
    public void removeSeat(Seat seat) {
        if(seat.getType() == SeatType.ECONOMY) {
            economySeat.remove(seat);
        }
        else if(seat.getType() == SeatType.BUSINESS) {
            businessSeat.remove(seat);
        }
    }

    @Override
    public Seat getNextAvailableSeat(SeatType type) {
        try {
            if(type == SeatType.ECONOMY) {
                return economySeat.first();
            }
            else if(type == SeatType.BUSINESS) {
                return businessSeat.first();
            }
        } catch (NoSuchElementException exception) {
            throw new FlightFullException();
        }
        return null;
    }
}
