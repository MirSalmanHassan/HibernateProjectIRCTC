package com.irctc.dao;

// Import statement
import com.irctc.entity.Passenger;

// This interface defines methods for accessing Passenger entities in the database.
public interface PassengerDAO {
    
    // This method is responsible for saving or updating a Passenger entity in the database.
    void saveOrUpdate(Passenger passenger);
    
    // This method is responsible for deleting a Passenger entity from the database.
    void delete(Passenger passenger);
    
    // This method retrieves a Passenger entity from the database based on its ID.
    Passenger getById(Long id);
}
