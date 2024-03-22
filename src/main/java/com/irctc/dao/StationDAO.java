package com.irctc.dao;

// Import statement
import com.irctc.entity.Station;

// This interface defines methods for accessing Station entities in the database.
public interface StationDAO {
    
    // This method is responsible for saving or updating a Station entity in the database.
    void saveOrUpdate(Station station);
    
    // This method is responsible for deleting a Station entity from the database.
    void delete(Station station);
    
    // This method retrieves a Station entity from the database based on its ID.
    Station getById(Long id);
}
