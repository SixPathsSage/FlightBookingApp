package com.leafvillage.flightbookingapp.service;

import com.leafvillage.flightbookingapp.datastore.BookingStore;
import com.leafvillage.flightbookingapp.exceptions.BookingAlreadyCancelledException;
import com.leafvillage.flightbookingapp.exceptions.InvalidSeatCountException;
import com.leafvillage.flightbookingapp.model.*;
import com.leafvillage.flightbookingapp.strategy.AllocationStrategy;

import java.util.ArrayList;
import java.util.List;

public class FlightBookingService {
    private AllocationStrategy strategy;
    private Flight flight;
    private BookingStore store;

    public FlightBookingService(AllocationStrategy strategy, Flight flight, BookingStore store) {
        this.strategy = strategy;
        this.flight = flight;
        this.store = store;
    }

    public void createFlight(int economy, int business) {
        if(economy < 0 || business < 0) {
            throw new InvalidSeatCountException();
        }
        int seatNumber = 1;
        for (int i = 1; i <= economy; i ++) {
            strategy.addSeat(new Seat(seatNumber, SeatType.ECONOMY));
            seatNumber ++;
        }

        for (int i = 1; i <= business; i ++) {
            strategy.addSeat(new Seat(seatNumber, SeatType.BUSINESS));
            seatNumber ++;
        }
    }

    public Booking bookEconomySeat(int count) {
        List<Seat> bookedSeats = new ArrayList<>();
        for(int i = 1; i <= count; i ++) {
            Seat seat = strategy.getNextAvailableSeat(SeatType.ECONOMY);
            flight.getSeats().add(seat);
            strategy.removeSeat(seat);
            bookedSeats.add(seat);
        }
        Double price = Double.valueOf(count * Properties.ECONOMY_COST);
        Long bookingId = store.getNextBookingId();
        Booking booking = new Booking(bookingId, bookedSeats, price);
        store.addBooking(booking);
        return booking;
    }

    public Booking bookBusinessSeat(int count) {
        List<Seat> bookedSeats = new ArrayList<>();
        for(int i = 1; i <= count; i ++) {
            Seat seat = strategy.getNextAvailableSeat(SeatType.BUSINESS);
            flight.getSeats().add(seat);
            strategy.removeSeat(seat);
            bookedSeats.add(seat);
        }
        Double price = Double.valueOf(count * Properties.BUSINESS_COST);
        Long bookingId = store.getNextBookingId();
        Booking booking = new Booking(bookingId, bookedSeats, price);
        store.addBooking(booking);
        return booking;
    }

    public Booking getBookingInformation(long bookingId) {
        return store.getBooking(bookingId);
    }

    public CancellationInfo cancelBooking(long bookingId) {
        Booking booking = store.getBooking(bookingId);
        if(booking.getStatus() == BookingStatus.CANCELLED) {
            throw new BookingAlreadyCancelledException(String.valueOf(bookingId));
        }
        for (Seat seat : booking.getBookedSeats()) {
            flight.getSeats().remove(seat);
            strategy.addSeat(seat);
        }
        booking.setStatus(BookingStatus.CANCELLED);
        Double cancellationFee = booking.getPrice() * (Properties.CANCELLATION_FEE_PERCENTAGE/100);
        Double refund = booking.getPrice() - cancellationFee;
        return new CancellationInfo(bookingId, booking.getBookedSeats(), cancellationFee, refund);
    }
}
