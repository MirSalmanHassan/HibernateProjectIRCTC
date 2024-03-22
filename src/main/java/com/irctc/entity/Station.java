// Package declaration
package com.irctc.entity;

// Import statements
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
@Table(name = "Station")
public class Station {
    
    // Id annotation marks the primary key field
    @Id
    // GeneratedValue annotation configures the way of primary key generation
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Column annotation specifies the mapping between this field and a column in the database
    @Column(name = "sourceStation")
    private String sourceStation;

    @Column(name = "destinationStation")
    private String destinationStation;

    // Establishing Many-to-One relationship with Passenger entity
    @ManyToOne
    // JoinColumn annotation defines the foreign key column
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    // Default constructor
    public Station() {
    }

    // Parameterized constructor
    public Station(Long id, String sourceStation, String destinationStation, Passenger passenger) {
        this.id = id;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
        this.passenger = passenger;
    }

    // Getter method for id
    public Long getId() {
        return id;
    }

    // Setter method for id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter method for sourceStation
    public String getSourceStation() {
        return sourceStation;
    }

    // Setter method for sourceStation
    public void setSourceStation(String sourceStation) {
        this.sourceStation = sourceStation;
    }

    // Getter method for destinationStation
    public String getDestinationStation() {
        return destinationStation;
    }

    // Setter method for destinationStation
    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }

    // Getter method for passenger
    public Passenger getPassenger() {
        return passenger;
    }

    // Setter method for passenger
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    // Override toString method to provide a string representation of the object
    @Override
    public String toString() {
        return "Station [id=" + id + ", sourceStation=" + sourceStation + ", destinationStation=" + destinationStation
                + ", passenger=" + passenger + "]";
    }
}
