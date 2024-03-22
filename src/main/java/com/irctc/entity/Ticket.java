// Package declaration
package com.irctc.entity;

// Import statements
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// Entity annotation indicates that this class is a JPA entity
@Entity
// Table annotation specifies the name of the table in the database
@Table(name = "Ticket")
public class Ticket {
    
    // Id annotation marks the primary key field
    @Id
    // GeneratedValue annotation configures the way of primary key generation
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Establishing Many-to-One relationship with Train entity
    @ManyToOne
    // JoinColumn annotation defines the foreign key column
    @JoinColumn(name = "train_id")
    private Train train;

    // Establishing Many-to-One relationship with Passenger entity
    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    // Establishing Many-to-One relationship with Booking entity
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    // Column annotation specifies the mapping between this field and a column in the database
    @Column(name = "seatNumber")
    private int seatNumber;

    @Column(name = "departureDate")
    private Date departureDate;

    @Column(name = "ticketFare_Rs")
    private double ticketFare; // Added ticketFare attribute

    // Default constructor
    public Ticket() {
    }

    // Parameterized constructor
    public Ticket(Train train, Passenger passenger, Booking booking, int seatNumber, Date departureDate, double ticketFare) {
        this.train = train;
        this.passenger = passenger;
        this.booking = booking;
        this.seatNumber = seatNumber;
        this.departureDate = departureDate;
        this.ticketFare = ticketFare;
    }

    // Getter method for id
    public Long getId() {
        return id;
    }

    // Setter method for id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter method for train
    public Train getTrain() {
        return train;
    }

    // Setter method for train
    public void setTrain(Train train) {
        this.train = train;
    }

    // Getter method for passenger
    public Passenger getPassenger() {
        return passenger;
    }

    // Setter method for passenger
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    // Getter method for booking
    public Booking getBooking() {
        return booking;
    }

    // Setter method for booking
    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    // Getter method for seatNumber
    public int getSeatNumber() {
        return seatNumber;
    }

    // Setter method for seatNumber
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    // Getter method for departureDate
    public Date getDepartureDate() {
        return departureDate;
    }

    // Setter method for departureDate
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    // Getter method for ticketFare
    public double getTicketFare() {
        return ticketFare;
    }

    // Setter method for ticketFare
    public void setTicketFare(double ticketFare) {
        this.ticketFare = ticketFare;
    }

    // Override toString method to provide a string representation of the object
    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", train=" + train +
                ", passenger=" + passenger +
                ", booking=" + booking +
                ", seatNumber=" + seatNumber +
                ", departureDate=" + departureDate +
                ", ticketFare=" + ticketFare +
                '}';
    }
}
