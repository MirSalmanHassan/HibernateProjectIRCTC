package com.irctc.service;

// Import statements
import com.irctc.dao.BookingDAO;
import com.irctc.entity.Booking;

// Service class for handling operations related to bookings
public class BookingService {
    
    private final BookingDAO bookingDAO; // DAO object for interacting with bookings

    // Constructor to initialize the BookingService with a BookingDAO
    public BookingService(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    // Method to save or update a booking
    public void saveOrUpdateBooking(Booking booking) {
        bookingDAO.saveOrUpdate(booking); // Delegating the operation to the DAO
    }

    // Method to delete a booking
    public void deleteBooking(Booking booking) {
        bookingDAO.delete(booking); // Delegating the operation to the DAO
    }

    // Method to retrieve a booking by its ID
    public Booking getBookingById(Long id) {
        return bookingDAO.getById(id); // Delegating the operation to the DAO
    }
}
