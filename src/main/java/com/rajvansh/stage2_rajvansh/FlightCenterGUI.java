package com.rajvansh.stage2_rajvansh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * FlightCenterGUI is the graphical user interface class that handles user input and output.
 * It interacts with the database and displays flights, customers, and bookings.
 */
public class FlightCenterGUI extends JFrame {
    private final Database db;  // Database connection object
    private final JTextArea flightDisplayArea;
    private final JTextArea customerDisplayArea;
    private final JTextArea bookingDisplayArea;

    private final ArrayList<Flight> flights;
    private final ArrayList<Customer> customers;
    private final ArrayList<Booking> bookings;

    /**
     * Constructor initializes the GUI and sets up the components.
     */
    public FlightCenterGUI() {
        db = new Database();  // Initialize the database connection
        
        flights = new ArrayList<>();  // Store Flight objects
        customers = new ArrayList<>();  // Store Customer objects
        bookings = new ArrayList<>();  // Store Booking objects

        flightDisplayArea = new JTextArea(20, 50);
        flightDisplayArea.setEditable(false);
        
        customerDisplayArea = new JTextArea(20, 50);
        customerDisplayArea.setEditable(false);
        
        bookingDisplayArea = new JTextArea(20, 50);
        bookingDisplayArea.setEditable(false);
        
        // Set up the main frame
        setTitle("Flight Center Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Create the tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // First tab: Flights
        JPanel flightPanel = new JPanel(new BorderLayout());
        flightPanel.add(new JScrollPane(flightDisplayArea), BorderLayout.CENTER);

        // Create buttons for flight management
        JButton addFlightButton = new JButton("Add Flight");
        JButton showFlightsButton = new JButton("Show Flights");
        JButton editFlightButton = new JButton("Edit Flight");
        JButton deleteFlightButton = new JButton("Delete Flight");

        addFlightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFlight();
            }
        });

        showFlightsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showFlights();
            }
        });

        editFlightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editFlight();
            }
        });

        deleteFlightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFlight();
            }
        });

        JPanel flightButtonPanel = new JPanel();
        flightButtonPanel.add(addFlightButton);
        flightButtonPanel.add(showFlightsButton);
        flightButtonPanel.add(editFlightButton);
        flightButtonPanel.add(deleteFlightButton);
        flightPanel.add(flightButtonPanel, BorderLayout.SOUTH);
        tabbedPane.add("Flights", flightPanel);

        // Second tab: Customers
        JPanel customerPanel = new JPanel(new BorderLayout());
        customerPanel.add(new JScrollPane(customerDisplayArea), BorderLayout.CENTER);

        // Create buttons for customer management
        JButton addCustomerButton = new JButton("Add Customer");
        JButton showCustomersButton = new JButton("Show Customers");
        JButton editCustomerButton = new JButton("Edit Customer");
        JButton deleteCustomerButton = new JButton("Delete Customer");

        addCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCustomer();
            }
        });

        showCustomersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCustomers();
            }
        });

        editCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editCustomer();
            }
        });

        deleteCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCustomer();
            }
        });

        JPanel customerButtonPanel = new JPanel();
        customerButtonPanel.add(addCustomerButton);
        customerButtonPanel.add(showCustomersButton);
        customerButtonPanel.add(editCustomerButton);
        customerButtonPanel.add(deleteCustomerButton);
        customerPanel.add(customerButtonPanel, BorderLayout.SOUTH);
        tabbedPane.add("Customers", customerPanel);

        // Third tab: Bookings
        JPanel bookingPanel = new JPanel(new BorderLayout());
        bookingPanel.add(new JScrollPane(bookingDisplayArea), BorderLayout.CENTER);

        // Create buttons for booking management
        JButton addBookingButton = new JButton("Add Booking");
        JButton showBookingsButton = new JButton("Show Bookings");
        JButton editBookingButton = new JButton("Edit Booking");
        JButton deleteBookingButton = new JButton("Delete Booking");

        addBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBooking();
            }
        });

        showBookingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showBookings();
            }
        });

        editBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editBooking();
            }
        });

        deleteBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBooking();
            }
        });

        JPanel bookingButtonPanel = new JPanel();
        bookingButtonPanel.add(addBookingButton);
        bookingButtonPanel.add(showBookingsButton);
        bookingButtonPanel.add(editBookingButton);
        bookingButtonPanel.add(deleteBookingButton);
        bookingPanel.add(bookingButtonPanel, BorderLayout.SOUTH);
        tabbedPane.add("Bookings", bookingPanel);

        // Add tabbed pane to the main frame
        add(tabbedPane, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }

    // Synchronize flights from the database to ArrayList
    private void syncFlightsFromDatabase() {
        flights.clear();
        ResultSet rs = db.getFlights();
        try {
            while (rs.next()) {
                String flightId = rs.getString("flight_id");
                String flightName = rs.getString("flight_name");
                int availableSeats = rs.getInt("available_seats");
                Flight flight = new Flight(flightId, flightName, null, availableSeats);
                flights.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Synchronize customers from the database to ArrayList
    private void syncCustomersFromDatabase() {
        customers.clear();
        ResultSet rs = db.getCustomers();
        try {
            while (rs.next()) {
                String customerId = rs.getString("customer_id");
                String name = rs.getString("name");
                String contactDetails = rs.getString("contact_details");
                Customer customer = new Customer(customerId, name, contactDetails);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Synchronize bookings from the database to ArrayList
    private void syncBookingsFromDatabase() {
        bookings.clear();
        ResultSet rs = db.getBookings();
        try {
            while (rs.next()) {
                String bookingId = rs.getString("booking_id");
                String flightId = rs.getString("flight_id");
                String customerId = rs.getString("customer_id");
                int seats = rs.getInt("seats");
                Booking booking = new Booking(bookingId, flightId, customerId, seats);
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addFlight() {
        String flightId = JOptionPane.showInputDialog(this, "Enter Flight ID:");
        String flightName = JOptionPane.showInputDialog(this, "Enter Flight Name:");
        String departure = JOptionPane.showInputDialog(this, "Enter Departure Location:");
        String destination = JOptionPane.showInputDialog(this, "Enter Destination:");
        int availableSeats = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Available Seats:"));

        if (flightId != null && flightName != null && departure != null && destination != null) {
            Flight flight = new Flight(flightId, flightName, null, availableSeats);  // Assuming departure date is null for simplicity
            flights.add(flight);  // Add flight to ArrayList
            db.addFlight(flightId, flightName, departure, destination);  // Add flight to the database
            JOptionPane.showMessageDialog(this, "Flight added successfully!");
        }
    }

    private void showFlights() {
        syncFlightsFromDatabase();  // Sync flights from database
        flightDisplayArea.setText("");  // Clear previous display
        for (Flight flight : flights) {
            flightDisplayArea.append("Flight ID: " + flight.getFlightId() +
                                     ", Name: " + flight.getFlightName() +
                                     ", Available Seats: " + flight.getAvailableSeats() + "\n");
        }
    }

    private void editFlight() {
        syncFlightsFromDatabase();  // Sync flights from database
        String flightId = JOptionPane.showInputDialog(this, "Enter Flight ID to Edit:");
        for (Flight flight : flights) {
            if (flight.getFlightId().equals(flightId)) {
                String newFlightName = JOptionPane.showInputDialog(this, "Enter New Flight Name:");
                String newDeparture = JOptionPane.showInputDialog(this, "Enter New Departure:");
                String newDestination = JOptionPane.showInputDialog(this, "Enter New Destination:");
                int newSeats = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter New Available Seats:"));

                flight.setFlightName(newFlightName);
                flight.setAvailableSeats(newSeats);

                db.updateFlight(flightId, newFlightName, newDeparture, newDestination, newSeats);  // Update flight in the database
                JOptionPane.showMessageDialog(this, "Flight updated successfully!");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Flight not found!");
    }

    private void deleteFlight() {
        syncFlightsFromDatabase();  // Sync flights from database
        String flightId = JOptionPane.showInputDialog(this, "Enter Flight ID to Delete:");

        // Check and delete related bookings first to avoid foreign key constraint issues
        db.deleteFlight(flightId);  // Delete all bookings related to this flight

        flights.removeIf(flight -> flight.getFlightId().equals(flightId));
        db.deleteFlight(flightId);  // Remove from the database
        JOptionPane.showMessageDialog(this, "Flight and related bookings deleted successfully!");
    }

    private void addCustomer() {
        String customerId = JOptionPane.showInputDialog(this, "Enter Customer ID:");
        String name = JOptionPane.showInputDialog(this, "Enter Customer Name:");
        String contactDetails = JOptionPane.showInputDialog(this, "Enter Contact Details:");

        if (customerId != null && name != null && contactDetails != null) {
            Customer customer = new Customer(customerId, name, contactDetails);
            customers.add(customer);  // Add customer to ArrayList
            db.addCustomer(customerId, name, contactDetails);  // Add customer to the database
            JOptionPane.showMessageDialog(this, "Customer added successfully!");
        }
    }

    private void showCustomers() {
        syncCustomersFromDatabase();  // Sync customers from database
        customerDisplayArea.setText("");  // Clear previous display
        for (Customer customer : customers) {
            customerDisplayArea.append("Customer ID: " + customer.getCustomerId() +
                                       ", Name: " + customer.getName() +
                                       ", Contact: " + customer.getContactDetails() + "\n");
        }
    }

    private void editCustomer() {
        syncCustomersFromDatabase();  // Sync customers from database
        String customerId = JOptionPane.showInputDialog(this, "Enter Customer ID to Edit:");
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                String newName = JOptionPane.showInputDialog(this, "Enter New Name:");
                String newContactDetails = JOptionPane.showInputDialog(this, "Enter New Contact Details:");

                customer.setName(newName);
                customer.setContactDetails(newContactDetails);

                db.updateCustomer(customerId, newName, newContactDetails);  // Update customer in the database
                JOptionPane.showMessageDialog(this, "Customer updated successfully!");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Customer not found!");
    }

    private void deleteCustomer() {
        syncCustomersFromDatabase();  // Sync customers from database
        String customerId = JOptionPane.showInputDialog(this, "Enter Customer ID to Delete:");

        // Check and delete related bookings first to avoid foreign key constraint issues
        db.deleteCustomer(customerId);  // Delete all bookings related to this customer

        customers.removeIf(customer -> customer.getCustomerId().equals(customerId));
        db.deleteCustomer(customerId);  // Remove from the database
        JOptionPane.showMessageDialog(this, "Customer and related bookings deleted successfully!");
    }

    private void addBooking() {
        String bookingId = JOptionPane.showInputDialog(this, "Enter Booking ID:");
        String flightId = JOptionPane.showInputDialog(this, "Enter Flight ID:");
        String customerId = JOptionPane.showInputDialog(this, "Enter Customer ID:");
        int seats = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Number of Seats:"));

        if (bookingId != null && flightId != null && customerId != null) {
            Booking booking = new Booking(bookingId, flightId, customerId, seats);
            bookings.add(booking);  // Add booking to ArrayList
            db.addBooking(bookingId, flightId, customerId, seats);  // Add booking to the database
            JOptionPane.showMessageDialog(this, "Booking added successfully!");
        }
    }

    private void showBookings() {
        syncBookingsFromDatabase();  // Sync bookings from database
        bookingDisplayArea.setText("");  // Clear previous display
        for (Booking booking : bookings) {
            bookingDisplayArea.append("Booking ID: " + booking.getBookingId() +
                                      ", Flight ID: " + booking.getFlightId() +
                                      ", Customer ID: " + booking.getCustomerId() +
                                      ", Seats: " + booking.getSeatsReserved() + "\n");
        }
    }

    private void editBooking() {
        syncBookingsFromDatabase();  // Sync bookings from database
        String bookingId = JOptionPane.showInputDialog(this, "Enter Booking ID to Edit:");
        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(bookingId)) {
                String newFlightId = JOptionPane.showInputDialog(this, "Enter New Flight ID:");
                String newCustomerId = JOptionPane.showInputDialog(this, "Enter New Customer ID:");
                int newSeats = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter New Seats:"));

                booking.setFlightId(newFlightId);
                booking.setCustomerId(newCustomerId);
                booking.setSeatsReserved(newSeats);

                db.updateBooking(bookingId, newFlightId, newCustomerId, newSeats);  // Update booking in the database
                JOptionPane.showMessageDialog(this, "Booking updated successfully!");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Booking not found!");
    }

    private void deleteBooking() {
        syncBookingsFromDatabase();  // Sync bookings from database
        String bookingId = JOptionPane.showInputDialog(this, "Enter Booking ID to Delete:");
        bookings.removeIf(booking -> booking.getBookingId().equals(bookingId));
        db.deleteBooking(bookingId);  // Remove from the database
        JOptionPane.showMessageDialog(this, "Booking deleted successfully!");
    }

    /**
     * Main method to run the FlightCenterGUI application.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Run the GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FlightCenterGUI();  // Create and display the GUI
            }
        });
    }
}
