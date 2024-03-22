package com.irctc.dao;

// Import statement
import com.irctc.entity.Ticket;

// This interface defines methods for accessing Ticket entities in the database.
public interface TicketDAO {
    
    // This method is responsible for saving or updating a Ticket entity in the database.
    void saveOrUpdate(Ticket ticket);
    
    // This method is responsible for deleting a Ticket entity from the database.
    void delete(Ticket ticket);
    
    // This method retrieves a Ticket entity from the database based on its ID.
    Ticket getById(Long id);
}
