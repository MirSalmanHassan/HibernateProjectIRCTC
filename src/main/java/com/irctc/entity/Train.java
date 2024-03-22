// Package declaration
package com.irctc.entity;

// Import statements
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Entity annotation indicates that this class is a JPA entity
@Entity
// Table annotation specifies the name of the table in the database
@Table(name = "Train")
public class Train {
    
    // Id annotation marks the primary key field
    @Id
    // GeneratedValue annotation configures the way of primary key generation
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Column annotation specifies the mapping between this field and a column in the database
    @Column(name = "name")
    private String name;

    @Column(name = "sourceStation")
    private String sourceStation;

    @Column(name = "destinationStation")
    private String destinationStation;
    
    @Column(name = "departureDate")
    private Date departureDate;

    // Default constructor
    public Train() {
    }

    // Parameterized constructor
    public Train(Long id, String name, String sourceStation, String destinationStation, Date departureDate) {
        this.id = id;
        this.name = name;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
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

    // Getter method for name
    public String getName() {
        return name;
    }

    // Setter method for name
    public void setName(String name) {
        this.name = name;
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
        return "Train{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sourceStation='" + sourceStation + '\'' +
                ", destinationStation='" + destinationStation + '\'' +
                ", departureDate=" + departureDate +
                '}';
    }
}
