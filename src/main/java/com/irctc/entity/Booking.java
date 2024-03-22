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
@Table(name = "Booking")
public class Booking {
    
    // Id annotation marks the primary key field
    @Id
    // GeneratedValue annotation configures the way of primary key generation
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Establishing Many-to-One relationship with Passenger entity
    @ManyToOne
    // JoinColumn annotation defines the foreign key column
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    // Column annotation specifies the mapping between this field and a column in the database
    @Column(name = "bookingDate")
    private Date bookingDate;

    // Column annotation specifies the mapping between this field and a column in the database
    @Column(name = "departureDate")
    private Date departureDate;
    
    // Default constructor
    public Booking() {
    }

    // Constructor with parameters
    public Booking(Passenger passenger, Date bookingDate, Date departureDate) {
        this.passenger = passenger;
        this.bookingDate = bookingDate;
        this.departureDate = departureDate;
    }

    // Getter method for id
    public Long getId() {
        return id;
    }

    // Setter method for id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter method for passenger
    public Passenger getPassenger() {
        return passenger;
    }

    // Setter method for passenger
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    // Getter method for bookingDate
    public Date getBookingDate() {
        return bookingDate;
    }

    // Setter method for bookingDate
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    // Getter method for departureDate
    public Date getDepartureDate() {
        return departureDate;
    }

    // Setter method for departureDate
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    // Override toString method to provide a string representation of the object
    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", passenger=" + passenger +
                ", bookingDate=" + bookingDate +
                ", departureDate=" + departureDate +
                '}';
    }    
}
