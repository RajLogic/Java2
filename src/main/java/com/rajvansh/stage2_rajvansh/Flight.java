package com.rajvansh.stage2_rajvansh;

import java.util.Date;

public class Flight {
    private String flightId;
    private String flightName;
    private Date departureDate;
    private int availableSeats;

    // Constructor
    public Flight(String flightId, String flightName, Date departureDate, int availableSeats) {
        this.flightId = flightId;
        this.flightName = flightName;
        this.departureDate = departureDate;
        this.availableSeats = availableSeats;
    }

    // Getter and Setter methods
    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public boolean bookSeats(int seatsToBook) {
        if (seatsToBook <= availableSeats) {
            availableSeats -= seatsToBook;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Flight ID: " + flightId + ", Name: " + flightName + ", Date: " + departureDate + ", Available Seats: " + availableSeats;
    }
}
