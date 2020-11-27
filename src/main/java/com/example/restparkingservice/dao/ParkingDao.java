package com.example.restparkingservice.dao;

import com.example.restparkingservice.model.Parking;

import java.util.List;
import java.util.UUID;

public interface ParkingDao {
    void addNewParking(Parking parking);
    List<Parking> getAllEntries();
    String getPrice(UUID parkingId);
    void updateParking(UUID parkingId, Parking parking);
    void deleteParkingById (UUID id);
}



