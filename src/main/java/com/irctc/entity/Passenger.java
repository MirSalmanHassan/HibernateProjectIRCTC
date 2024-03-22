// Package declaration
package com.irctc.entity;

// Import statements
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// Entity annotation indicates that this class is a JPA entity
@Entity
// Table annotation specifies the name of the table in the database
@Table(name = "Passenger")
public class Passenger {
    
    // Id annotation marks the primary key field
    @Id
    // GeneratedValue annotation configures the way of primary key generation
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Column annotation specifies the mapping between this field and a column in the database
    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    // Establishing a One-to-Many relationship with Station entities
    @OneToMany(mappedBy = "passenger", cascade = CascadeType.ALL)
    private List<Station> station;

    // Default constructor
    public Passenger() {
    }

    // Constructor with parameters
    public Passenger(String name, String email) {
        this.name = name;
        this.email = email;
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

    // Getter method for email
    public String getEmail() {
        return email;
    }

    // Setter method for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter method for station
    public List<Station> getStation() {
        return station;
    }

    // Setter method for station
    public void setStation(List<Station> station) {
        this.station = station;
    }

    // Override toString method to provide a string representation of the object
    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
