package com.irctc.service;

// Import statements
import com.irctc.entity.Booking;
import com.irctc.entity.Passenger;
import com.irctc.entity.Station;
import com.irctc.entity.Ticket;
import com.irctc.entity.Train;
import com.irctc.exceptions.CustomException;

// This interface defines methods for providing services related to IRCTC.
public interface IRCTCService {
    
    // This method is responsible for booking a ticket for a specific train and station for a user.
    void bookTicket(Train train, Station station, Passenger passenger) throws CustomException;
    
    // This method is responsible for canceling a booked ticket by providing the booking details.
    void cancelTicket(Booking booking) throws CustomException;
    
    // This method retrieves the details of a ticket based on its ID.
    Ticket getTicketDetails(Long ticketId) throws CustomException;
}
