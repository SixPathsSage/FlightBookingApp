package com.leafvillage.flightbookingapp.datastore;

import com.leafvillage.flightbookingapp.exceptions.BookingNotFoundException;
import com.leafvillage.flightbookingapp.model.Booking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BookingStore {
    private Map<Long, Booking> bookings;
    private Long lastBookingId;

    public BookingStore() {
        bookings = new HashMap<>();
        lastBookingId = 0L;
    }

    public void addBooking(Booking booking) {
        bookings.put(booking.getBookingId(), booking);
    }

    public Booking getBooking(Long bookingId) {
        if(!bookings.containsKey(bookingId)) {
            throw new BookingNotFoundException(String.valueOf(bookingId));
        }

        return bookings.get(bookingId);
    }

    public Long getNextBookingId() {
        return ++ lastBookingId;
    }
}
