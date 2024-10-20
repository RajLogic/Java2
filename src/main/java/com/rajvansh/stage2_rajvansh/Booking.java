package com.rajvansh.stage2_rajvansh;

public class Booking {
    private String bookingId;
    private String flightId;
    private String customerId;
    private int seatsReserved;

    public Booking(String bookingId, String flightId, String customerId, int seatsReserved) {
        this.bookingId = bookingId;
        this.flightId = flightId;
        this.customerId = customerId;
        this.seatsReserved = seatsReserved;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getSeatsReserved() {
        return seatsReserved;
    }

    public void setSeatsReserved(int seatsReserved) {
        this.seatsReserved = seatsReserved;
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingId + ", Flight ID: " + flightId + ", Customer ID: " + customerId + ", Seats: " + seatsReserved;
    }
}
