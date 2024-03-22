package com.irctc.dao;

// Import statements
import com.irctc.entity.Train;

// This interface defines methods for accessing Train entities in the database.
public interface TrainDAO {
    
    // This method is responsible for saving or updating a Train entity in the database.
    void saveOrUpdate(Train train);
    
    // This method is responsible for deleting a Train entity from the database.
    void delete(Train train);
    
    // This method retrieves a Train entity from the database based on its ID.
    Train getById(Long id);
}
