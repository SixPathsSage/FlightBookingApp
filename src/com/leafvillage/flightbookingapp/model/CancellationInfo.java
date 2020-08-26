package com.leafvillage.flightbookingapp.model;

import java.util.List;

public class CancellationInfo {
    private Long bookingId;
    private List<Seat> cancelledSeats;
    private Double cancellationFee;
    private Double refundAmount;

    public CancellationInfo(Long bookingId, List<Seat> cancelledSeats, Double cancellationFee, Double refundAmount) {
        this.bookingId = bookingId;
        this.cancelledSeats = cancelledSeats;
        this.cancellationFee = cancellationFee;
        this.refundAmount = refundAmount;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public List<Seat> getCancelledSeats() {
        return cancelledSeats;
    }

    public void setCancelledSeats(List<Seat> cancelledSeats) {
        this.cancelledSeats = cancelledSeats;
    }

    public Double getCancellationFee() {
        return cancellationFee;
    }

    public void setCancellationFee(Double cancellationFee) {
        this.cancellationFee = cancellationFee;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CancellationInfo{");
        sb.append("bookingId=").append(bookingId);
        sb.append(", cancelledSeats=").append(cancelledSeats);
        sb.append(", cancellationFee=").append(cancellationFee);
        sb.append(", refundAmount=").append(refundAmount);
        sb.append('}');
        return sb.toString();
    }
}
