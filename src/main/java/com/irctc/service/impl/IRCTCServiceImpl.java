package com.irctc.service.impl;

import java.util.Date;

import com.irctc.entity.Booking;
import com.irctc.entity.Passenger;
import com.irctc.entity.Station;
import com.irctc.entity.Ticket;
import com.irctc.entity.Train;
import com.irctc.exceptions.CustomException;
import com.irctc.service.IRCTCService;

public class IRCTCServiceImpl implements IRCTCService {

    @Override
    public void bookTicket(Train train, Station station, Passenger passenger) throws CustomException {
        try {
            // code logic for booking ticket
            Date currentDate = new Date();
            if (currentDate.before(train.getDepartureDate())) {
                System.out.println("Booking ticket for train: " + train.getName() + " from station: " + station.getSourceStation() + " to station: " + station.getDestinationStation() + " for user: " + passenger.getName());
                // Perform the actual booking process here
            } else {
                throw new CustomException("Failed to book ticket: Departure date has already passed");
            }
        } catch (Exception e) {
            throw new CustomException("Failed to book ticket: " + e.getMessage());
        }
    }

    @Override
    public void cancelTicket(Booking booking) throws CustomException {
        try {
            // code logic for canceling ticket
            Date currentDate = new Date();
            if (currentDate.after(booking.getDepartureDate())) {
                System.out.println("Canceling ticket for booking ID: " + booking.getId());
                // Perform the actual cancellation process here
            } else {
                throw new CustomException("Failed to cancel ticket: Cannot cancel before departure date");
            }
        } catch (Exception e) {
            throw new CustomException("Failed to cancel ticket: " + e.getMessage());
        }
    }

    @Override
    public Ticket getTicketDetails(Long ticketId) throws CustomException {
        try {
            // code logic for retrieving ticket details
            if (ticketId == null) {
                throw new CustomException("Failed to retrieve ticket details: Ticket ID is null");
            }
            System.out.println("Retrieving ticket details for ticket ID: " + ticketId);
            // Perform the actual retrieval process here
            return null; // Replace 'null' with actual ticket object
        } catch (Exception e) {
            throw new CustomException("Failed to retrieve ticket details: " + e.getMessage());
        }
    }
}
