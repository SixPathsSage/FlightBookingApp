package com.leafvillage.flightbookingapp.strategy;

import com.leafvillage.flightbookingapp.model.Seat;
import com.leafvillage.flightbookingapp.model.SeatType;

public interface AllocationStrategy {
    void addSeat(Seat seat);
    void removeSeat(Seat seat);
    Seat getNextAvailableSeat(SeatType type);
}
