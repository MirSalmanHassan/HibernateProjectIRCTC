package com.irctc.service;

// Import statements
import com.irctc.dao.TicketDAO;
import com.irctc.entity.Ticket;

// Service class for managing operations related to tickets
public class TicketService {
    
    private final TicketDAO ticketDAO; // Data Access Object for tickets

    // Constructor to initialize the TicketService with a TicketDAO
    public TicketService(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    // Method to save or update a ticket
    public void saveOrUpdateTicket(Ticket ticket) {
        ticketDAO.saveOrUpdate(ticket); // Delegating the operation to the DAO
    }

    // Method to delete a ticket
    public void deleteTicket(Ticket ticket) {
        ticketDAO.delete(ticket); // Delegating the operation to the DAO
    }

    // Method to retrieve a ticket by its ID
    public Ticket getTicketById(Long id) {
        return ticketDAO.getById(id); // Delegating the operation to the DAO
    }
}
