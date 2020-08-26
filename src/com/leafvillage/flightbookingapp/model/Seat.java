package com.leafvillage.flightbookingapp.model;

import com.leafvillage.flightbookingapp.exceptions.InvalidSeatNumberException;

import java.util.Objects;

public class Seat implements Comparable<Seat>{
    private Integer number;
    private SeatType type;

    public Seat(int number, SeatType type) {
        this.number = number;
        this.type = type;
    }

    public Seat(int number, boolean isOccupied, SeatType type) {
        this.number = number;
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if(number < 0) {
            throw new InvalidSeatNumberException(String.valueOf(number));
        }
        this.number = number;
    }


    public SeatType getType() {
        return type;
    }

    public void setType(SeatType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return Objects.equals(number, seat.number) &&
                type == seat.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, type);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Seat{");
        sb.append("number=").append(number);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Seat seat) {
        return this.getNumber().compareTo(seat.number);
    }
}
