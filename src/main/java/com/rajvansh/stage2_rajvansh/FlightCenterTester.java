package com.rajvansh.stage2_rajvansh;

import java.util.Date;

public class FlightCenterTester extends FlightCenter {


    public static void main(String[] arg) {
        FlightCenter FC = new FlightCenter();

        customers.add(new Customer("C001", "John Doe", "johndoe@example.com"));
        customers.add(new Customer("C002", "Jane Smith", "janesmith@example.com"));
        customers.add(new Customer("C003", "Michael Brown", "michaelbrown@example.com"));

        flights.add(new Flight("FL001", "Flight to New York", new Date(), 100));
        flights.add(new Flight("FL002", "Flight to London", new Date(), 0));  // No seats available
        flights.add(new Flight("FL003", "Flight to Tokyo", new Date(), 60));

        bookings.add(new Booking("B001", "C001", "FL001", 2));
        bookings.add(new Booking("B002", "C002", "FL001", 1));
        bookings.add(new Booking("B003", "C003", "FL003", 3));


        // Display all customers, flights and bookings
        FC.listCustomers();
        System.out.println("--------------------");
        FC.listFlights();
        System.out.println("--------------------");
        FC.listBookings();
        System.out.println("--------------------");

        System.out.println("Update customer C001");
        FC.editCustomer();
        System.out.println("--------------------");

        System.out.println("Delete customer C002");
        FC.deleteCustomer();
        System.out.println("--------------------");

        System.out.println("Add new customer");
        FC.addCustomer();
        System.out.println("--------------------");

        FC.listCustomers();
        System.out.println("--------------------");

        FC.listBookings();
        System.out.println("--------------------");

        System.out.println("Update booking B001");
        FC.editBookings();
        System.out.println("--------------------");

        FC.listBookings();
        System.out.println("--------------------");

        System.out.println("Delete booking B002");
        FC.deleteBooking();
        System.out.println("--------------------");

        FC.listBookings();
        System.out.println("--------------------");

        System.out.println("Add new booking");
        FC.addBooking();
        System.out.println("--------------------");

        FC.listFlights();
        System.out.println("--------------------");

        System.out.println("Update Flight FL001");
        FC.editFlight();
        System.out.println("--------------------");


        System.out.println("Delete Flight FL002");
        FC.deleteFlight();
        System.out.println("--------------------");


        System.out.println("Add new Flight");
        FC.addFlight();
        System.out.println("--------------------");

        FC.listFlights();
        System.out.println("--------------------");


        // Display all customers, flights and bookings
        FC.listCustomers();
        System.out.println("--------------------");
        FC.listFlights();
        System.out.println("--------------------");
        FC.listBookings();
        System.out.println("--------------------");






    }
}