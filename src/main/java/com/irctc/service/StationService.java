package com.irctc.service;

// Import statements
import com.irctc.dao.StationDAO;
import com.irctc.entity.Station;

// Service class for handling operations related to stations
public class StationService {
    
    private final StationDAO stationDAO; // DAO object for interacting with stations

    // Constructor to initialize the StationService with a StationDAO
    public StationService(StationDAO stationDAO) {
        this.stationDAO = stationDAO;
    }

    // Method to save or update a station
    public void saveOrUpdateStation(Station station) {
        stationDAO.saveOrUpdate(station); // Delegating the operation to the DAO
    }

    // Method to delete a station
    public void deleteStation(Station station) {
        stationDAO.delete(station); // Delegating the operation to the DAO
    }

    // Method to retrieve a station by its ID
    public Station getStationById(Long id) {
        return stationDAO.getById(id); // Delegating the operation to the DAO
    }
}
