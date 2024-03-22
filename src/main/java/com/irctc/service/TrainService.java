package com.irctc.service;

// Import statements
import com.irctc.dao.TrainDAO;
import com.irctc.entity.Train;

// Service class for managing operations related to trains
public class TrainService {
    private final TrainDAO trainDAO; // Data Access Object for trains

    // Constructor to initialize the TrainService with a TrainDAO
    public TrainService(TrainDAO trainDAO) {
        this.trainDAO = trainDAO;
    }

    // Method to save or update a train
    public void saveOrUpdateTrain(Train train) {
        trainDAO.saveOrUpdate(train); // Delegating the operation to the DAO
    }

    // Method to delete a train
    public void deleteTrain(Train train) {
        trainDAO.delete(train); // Delegating the operation to the DAO
    }

    // Method to retrieve a train by its ID
    public Train getTrainById(Long id) {
        return trainDAO.getById(id); // Delegating the operation to the DAO
    }
}
