package com.leafvillage.flightbookingapp.model;

import com.leafvillage.flightbookingapp.exceptions.InvalidBookingIdException;

import java.util.List;

public class Booking {
    private Long bookingId;
    private List<Seat> bookedSeats;
    private BookingStatus status;
    private Double price;

    public Booking(Long bookingId, List<Seat> bookedSeats,Double price) {
        this.bookingId = bookingId;
        this.bookedSeats = bookedSeats;
        this.price = price;
        status = BookingStatus.ACTIVE;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        if(bookingId < 0) { throw new InvalidBookingIdException(String.valueOf(bookingId)); }
        this.bookingId = bookingId;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Seat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Booking{");
        sb.append("bookingId=").append(bookingId);
        sb.append(", bookedSeats=").append(bookedSeats);
        sb.append(", status=").append(status);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
