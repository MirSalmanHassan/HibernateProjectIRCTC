package com.irctc.service;

// Import statements
import com.irctc.dao.PassengerDAO;
import com.irctc.entity.Passenger;

// Service class for managing operations related to users
public class PassengerService {
    private final PassengerDAO passengerDAO; // Data Access Object for users

    // Constructor to initialize the UserService with a UserDAO
    public PassengerService(PassengerDAO passengerDAO) {
        this.passengerDAO = passengerDAO;
    }

    // Method to save or update a user
    public void saveOrUpdateUser(Passenger passenger) {
       passengerDAO.saveOrUpdate(passenger); // Delegating the operation to the DAO
    }

    // Method to delete a user
    public void deleteUser(Passenger passenger) {
        passengerDAO.delete(passenger); // Delegating the operation to the DAO
    }

    // Method to retrieve a user by their ID
    public Passenger getPassengerById(Long id) {
        return passengerDAO.getById(id); // Delegating the operation to the DAO
    }
}
