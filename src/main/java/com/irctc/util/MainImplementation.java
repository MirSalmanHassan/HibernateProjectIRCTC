package com.irctc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.irctc.entity.Booking;
import com.irctc.entity.Passenger;
import com.irctc.entity.Station;
import com.irctc.entity.Ticket;
import com.irctc.entity.Train;
import com.irctc.exceptions.CustomException;

// This class provides utility methods for interacting with Hibernate ORM.
public class MainImplementation {

    public static void main(String[] args) {
        // Establishing the connection to Hibernate by configuring the StandardServiceRegistry
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                .configure("Configuration.xml") // Corrected the configuration file name
                .build();

        // Creating metadata from the specified service registry
        Metadata metadata = new MetadataSources(standardServiceRegistry)
                .getMetadataBuilder()
                .build();

        // Creating SessionFactory from metadata
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Changed buildSessionFactory() to getSessionFactoryBuilder().build()

        // Opening a session from SessionFactory
        Session session = sessionFactory.openSession();

        // Beginning a transaction
        Transaction transaction = session.beginTransaction();

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Select operation:");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Retrieve Ticket Details");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    bookTicket(session, scanner);
                    break;
                case 2:
                    cancelTicket(session, scanner);
                    break;
                case 3:
                    retrieveTicketDetails(session, scanner);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } catch (CustomException ce) {
            System.out.println("Custom Exception: " + ce.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Committing the transaction
            transaction.commit();

            // Closing the session
            session.close();

            // Closing the SessionFactory
            sessionFactory.close();
        }
    }

    private static void bookTicket(Session session, Scanner scanner) throws CustomException, ParseException {
        System.out.println("Enter train name:");
        String trainName = scanner.nextLine();

        System.out.println("Enter source station:");
        String sourceStationName = scanner.nextLine();

        System.out.println("Enter destination station:");
        String destinationStationName = scanner.nextLine();

        System.out.println("Enter passenger name:");
        String passengerName = scanner.nextLine();

        System.out.println("Enter user email:");
        String passengerEmail = scanner.nextLine();

        System.out.println("Enter departure date (\"dd-MM-yyyy\"):");
        String departureDateStr = scanner.nextLine();
        Date departureDate = parseDate(departureDateStr);

        System.out.println("Enter ticket fare:");
        double ticketFare = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        Train train = new Train(null, trainName, sourceStationName, destinationStationName, departureDate);
        Station station = new Station(null, sourceStationName, destinationStationName, null);

        Passenger passenger = new Passenger(passengerName, passengerEmail);
        Booking booking = new Booking(passenger, new Date(), departureDate);
        Ticket ticket = new Ticket(train, passenger, booking, 1, departureDate, ticketFare);

        session.save(train);
        session.save(station);

        session.save(passenger);
        session.save(booking);
        session.save(ticket);

        // Set passenger_id in Station entity
        station.setPassenger(passenger);
        session.save(station);

        System.out.println("Ticket booked successfully!");
    }

    private static void cancelTicket(Session session, Scanner scanner) throws CustomException {
        System.out.println("Enter booking ID:");
        Long bookingId = scanner.nextLong();
        scanner.nextLine(); // Consume newline character

        Booking booking = session.get(Booking.class, bookingId);
        if (booking == null) {
            throw new CustomException("Booking not found with ID: " + bookingId);
        }

        session.delete(booking);
        System.out.println("Ticket canceled successfully!");
    }

    private static void retrieveTicketDetails(Session session, Scanner scanner) throws CustomException {
        System.out.println("Enter ticket ID:");
        Long ticketId = scanner.nextLong();
        scanner.nextLine(); // Consume newline character

        Ticket ticket = session.get(Ticket.class, ticketId);
        if (ticket == null) {
            throw new CustomException("Ticket not found with ID: " + ticketId);
        }

        System.out.println("Ticket details:");
        System.out.println(ticket);
    }

    private static Date parseDate(String dateString) throws CustomException, ParseException {
        return new SimpleDateFormat("dd-MM-yyyy").parse(dateString);
    }
}
