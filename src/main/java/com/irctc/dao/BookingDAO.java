// Package declaration
package com.irctc.dao;

// Import statement
import com.irctc.entity.Booking;

// This interface defines methods for accessing Booking entities in the database.
public interface BookingDAO {
    
    // This method is responsible for saving or updating a Booking entity in the database.
    void saveOrUpdate(Booking booking);
    
    // This method is responsible for deleting a Booking entity from the database.
    void delete(Booking booking);
    
    // This method retrieves a Booking entity from the database based on its ID.
    Booking getById(Long id);
}
