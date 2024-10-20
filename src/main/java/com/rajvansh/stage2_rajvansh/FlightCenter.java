package com.rajvansh.stage2_rajvansh;


import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FlightCenter {
    public static ArrayList<Flight> flights = new ArrayList<>();
    public static final ArrayList<Customer> customers = new ArrayList<>();
    public static final ArrayList<Booking> bookings = new ArrayList<>();
    public final Scanner scanner = new Scanner(System.in);
    private static int bookingCounter = 1;

    public static void main(String[] args) {
        FlightCenter flightCenter = new FlightCenter();
        flightCenter.menu();
    }



    public void menu() {
        while (true) {
            System.out.println("\nFlight Center Menu:\n ----------");
            System.out.println("Flights:");
            System.out.println("1. Add Flight");
            System.out.println("2. List Flights");
            System.out.println("3. Edit Flight");
            System.out.println("4. Delete Flight\n ----------");
            System.out.println("Customers:");
            System.out.println("5. Add Customer");
            System.out.println("6. List Customers");
            System.out.println("7. Edit Customer");
            System.out.println("8. Delete Customer\n ----------");
            System.out.println("Bookings:");
            System.out.println("9. Add Booking");
            System.out.println("10. List Bookings");
            System.out.println("11. Edit Bookings");
            System.out.println("12. Delete Booking\n ----------");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");



            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                // Flight operations
                case 1:
                    addFlight();
                    break;
                case 2:
                    listFlights();
                    break;
                case 3:
                    editFlight();
                    break;
                case 4:
                    deleteFlight();
                    break;

                // Customer operations
                case 5:
                    addCustomer();
                    break;
                case 6:
                    listCustomers();
                    break;
                case 7:
                    editCustomer();
                    break;
                case 8:
                    deleteCustomer();
                    break;

                // Booking operations
                case 9:
                    addBooking();
                    break;
                case 10:
                    listBookings();
                    break;
                case 11:
                    editBookings();
                    break;
                case 12:
                    deleteBooking();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }


        }
    }


    // Add a new flight
    public void addFlight() {
        System.out.print("Enter Flight ID: ");
        String flightId = scanner.nextLine();

        // Check if the Flight ID already exists
        for (Flight flight : flights) {
            if (flight.getFlightId().equals(flightId)) {
                System.out.println("Flight ID already exists.");
                return;
            }
        }

        if (flightId.length() != 5) {
            System.out.println("Flight ID must be 5 characters long.");
            return;
        }

        System.out.print("Enter Flight Country: ");
        String flightName = scanner.nextLine();
        if (flightName.length() < 3) {
            System.out.println("Flight Country must be at least 3 characters long.");
            return;
        }

        System.out.print("Enter Available Seats: ");
        int availableSeats = scanner.nextInt();
        if (availableSeats <= 0) {
            System.out.println("Invalid number of seats.");
            return;
        }

        // After validation, add the new flight
        flights.add(new Flight(flightId, flightName, new Date(), availableSeats));
        System.out.println("Flight added successfully.");
    }


    // List all flights
    public void listFlights() {
        System.out.println("\nAvailable Flights:");
        if (flights.isEmpty()) {
            System.out.println("No flights found.");
            return;
        } else {
            for (Flight flight : flights) {
                System.out.println(flight);
            }
        }
    }

    public void editFlight() {
        System.out.print("Enter Flight ID: ");
        String flightId = scanner.nextLine();
        for (Flight flight : flights) {
            if (flight.getFlightId().equals(flightId)) {
                System.out.print("Enter new Flight Name: ");
                String flightName = scanner.nextLine();
                if (flightName.length() < 3) {
                    System.out.println("Flight Name must be at least 3 characters long.");
                    return;
                }
                System.out.print("Enter new Available Seats: ");
                int availableSeats = scanner.nextInt();

                flight.setFlightName(flightName);
                flight.setAvailableSeats(availableSeats);
                System.out.println("Flight details updated successfully.");
                return;
            }
        } System.out.println("Flight ID not found.");
    }

    // List flights with available seats (for booking)
    public void listAvailableFlights() {
        System.out.println("\nFlights with Available Seats:");
        if (flights.isEmpty()) {
            System.out.println("No flights found.");
            return;
        }else {
            for (Flight flight : flights) {
                if (flight.getAvailableSeats() > 0) {
                    System.out.println(flight);
                }
            }
        }
    }

    // Add a new customer
    public void addCustomer() {
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();
        for (Customer customer : customers) {

            if (customer.getCustomerId().equals(customerId)) {
                System.out.println("Customer ID already exists.");
                return;
            }
            if (customerId.length() != 4) {
                System.out.println("Customer ID must be 4 characters long.");
                return;
            }
        }
        if (customerId.length() != 4) {
            System.out.println("Customer ID must be 4 characters long.");
            return;
        }
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        if (name.length() < 3) {
            System.out.println("Name must be at least 3 characters long.");
            return;
        }
        System.out.print("Enter Contact Details: ");
        String contactDetails = scanner.nextLine();


        customers.add(new Customer(customerId, name, contactDetails));
        System.out.println("Customer added successfully.");
    }

    // List all customers
    public void listCustomers() {
        System.out.println("\nRegistered Customers:");
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        } else {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    // Edit an existing customer
    public void editCustomer() {
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();

        // Search for the customer by ID
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {

                // Edit customer details
                System.out.print("Enter new Name: ");
                String name = scanner.nextLine();
                if (name.length() < 3) {
                    System.out.println("Name must be at least 3 characters long.");
                    return;
                }

                System.out.print("Enter new Contact Details: ");
                String contactDetails = scanner.nextLine();

                // Update the customer information
                customer.setName(name);
                customer.setContactDetails(contactDetails);
                System.out.println("Customer details updated successfully.");
                return;  // Exit after updating
            }
        }

        // If customer ID is not found
        System.out.println("Customer ID not found.");
    }


    public void addBooking () {
        listAvailableFlights();
        if (flights.isEmpty()) {
            System.out.println("No flights available for booking.");
            return;
        }
        System.out.print("Enter Flight ID: ");
        String flightId = scanner.nextLine();
        Flight selectedFlight = null;
        for (Flight flight : flights) {
            if (flight.getFlightId().equals(flightId)) {
                selectedFlight = flight;
                break;
            }
        }
        if (selectedFlight == null) {
            System.out.println("Flight ID not found.");
            return;
        }



        System.out.println("\nRegistered Customers:");
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        for (Customer customer : customers) {
            System. out.println(customer);
        }

        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();
        Customer selectedCustomer = null;
        for (Customer customer : customers) {

            if (customer.getCustomerId().equals(customerId)) {
                selectedCustomer = customer;
                break;
            }
        }
        if (selectedCustomer == null) {
            System.out.println("Customer ID not found.");
            return;
        }

        System.out.print("Enter Seats to Book: ");
        int seatsToBook = scanner.nextInt();
        if (seatsToBook <= 0) {
            System.out.println("Invalid number of seats.");
            return;
        }
        if (selectedFlight.bookSeats(seatsToBook)) {
            bookings.add(new Booking(String.format("B%03d", bookingCounter++), customerId, flightId, seatsToBook));
            System.out.println("Booking successful.");
        } else {
            System.out.println("Booking failed. Insufficient seats.");
        }
    }

    public void listBookings() {
        System.out.println("\nBookings:");
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        } else {
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        }
    }

    public void editBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }
        listBookings();
        System.out.print("Enter Booking ID: ");
        String bookingId = scanner.nextLine();
        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(bookingId)) {
                listCustomers();
                System.out.print("Enter new Customer ID: ");
                String customerId = scanner.nextLine();
                for (Customer customer : customers) {
                    if (customer.getCustomerId().equals(customerId)) {
                        booking.setCustomerId(customerId);
                        break;
                    }
                }

                listAvailableFlights();
                System.out.print("Enter new Flight ID: ");
                String flightId = scanner.nextLine();
                for (Flight flight : flights) {
                    if (flight.getFlightId().equals(flightId)) {
                        booking.setFlightId(flightId);
                        break;
                    } else {
                        System.out.println("Flight ID not found.");
                    }
                }


                System.out.print("Enter new Seats Reserved: ");
                int seatsReserved = scanner.nextInt();
                if (seatsReserved <= 0) {
                    System.out.println("Invalid number of seats.");
                    return;
                }
                booking.setCustomerId(customerId);
                booking.setFlightId(flightId);
                booking.setSeatsReserved(seatsReserved);
                System.out.println("Booking details updated successfully.");
                return;
            } else {
                System.out.println("Booking ID not found.");
            }
        }
    }

    // Delete a flight
    public void deleteFlight() {
        if (flights.isEmpty()) {
            System.out.println("No flights found.");
            return;
        }
        listFlights();
        System.out.print("Enter Flight ID to delete: ");
        String flightId = scanner.nextLine();
        for (Flight flight : flights) {
            if (flight.getFlightId().equals(flightId)) {
                flights.remove(flight);
                System.out.println("Flight deleted successfully.");
                return;
            }
        }
        System.out.println("Flight ID not found.");
    }

    // Delete a customer
    public void deleteCustomer() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        listCustomers();
        System.out.print("Enter Customer ID to delete: ");
        String customerId = scanner.nextLine();
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                customers.remove(customer);
                System.out.println("Customer deleted successfully.");
                return;
            }
        }
        System.out.println("Customer ID not found.");
    }

    // Delete a booking
    public void deleteBooking() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }
        listBookings();
        System.out.print("Enter Booking ID to delete: ");
        String bookingId = scanner.nextLine();
        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(bookingId)) {
                bookings.remove(booking);
                System.out.println("Booking deleted successfully.");
                return;
            }
        }
        System.out.println("Booking ID not found.");
    }



}
