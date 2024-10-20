package com.rajvansh.stage2_rajvansh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    private Connection conn;

    public Database() {
        try {
            // Connect to the MySQL database (for MySQL, change URL as needed for SQLite)
            String url = "jdbc:mysql://localhost:3306/flight_center";  // Update for SQLite if needed (jdbc:sqlite:flight_center.Database)
            String user = "root";  // For SQLite, you don't need a username
            String password = "";  // For SQLite, you don't need a password
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add a flight
    public void addFlight(String flightId, String flightName, String departure, String destination) {
        String sql = "INSERT INTO flights (flight_id, flight_name, departure, destination, available_seats) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, flightId);
            stmt.setString(2, flightName);
            stmt.setString(3, departure);
            stmt.setString(4, destination);
            stmt.setInt(5, 150);  // Default available seats
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to update a flight
    public void updateFlight(String flightId, String flightName, String departure, String destination, int availableSeats) {
        String sql = "UPDATE flights SET flight_name = ?, departure = ?, destination = ?, available_seats = ? WHERE flight_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, flightName);
            stmt.setString(2, departure);
            stmt.setString(3, destination);
            stmt.setInt(4, availableSeats);
            stmt.setString(5, flightId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a flight
    public void deleteFlight(String flightId) {
        String sql = "DELETE FROM flights WHERE flight_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, flightId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all flights
    public ResultSet getFlights() {
        String sql = "SELECT * FROM flights";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            return stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to add a customer
    public void addCustomer(String customerId, String name, String contactDetails) {
        String sql = "INSERT INTO customers (customer_id, name, contact_details) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customerId);
            stmt.setString(2, name);
            stmt.setString(3, contactDetails);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to update a customer
    public void updateCustomer(String customerId, String name, String contactDetails) {
        String sql = "UPDATE customers SET name = ?, contact_details = ? WHERE customer_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, contactDetails);
            stmt.setString(3, customerId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a customer
    public void deleteCustomer(String customerId) {
        String sql = "DELETE FROM customers WHERE customer_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customerId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all customers
    public ResultSet getCustomers() {
        String sql = "SELECT * FROM customers";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            return stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to add a booking
    public void addBooking(String bookingId, String flightId, String customerId, int seats) {
        String sql = "INSERT INTO bookings (booking_id, flight_id, customer_id, seats) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, bookingId);
            stmt.setString(2, flightId);
            stmt.setString(3, customerId);
            stmt.setInt(4, seats);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to update a booking
    public void updateBooking(String bookingId, String flightId, String customerId, int seats) {
        String sql = "UPDATE bookings SET flight_id = ?, customer_id = ?, seats = ? WHERE booking_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, flightId);
            stmt.setString(2, customerId);
            stmt.setInt(3, seats);
            stmt.setString(4, bookingId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a booking
    public void deleteBooking(String bookingId) {
        String sql = "DELETE FROM bookings WHERE booking_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, bookingId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all bookings
    public ResultSet getBookings() {
        String sql = "SELECT * FROM bookings";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            return stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
}
