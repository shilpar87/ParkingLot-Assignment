package com.example.restparkingservice.service;

import com.example.restparkingservice.dao.MockedParkingDataAccessService;
import com.example.restparkingservice.model.Parking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class ParkingService {
    private final MockedParkingDataAccessService parkingDataAccessService;

    @Autowired
    public ParkingService(@Qualifier("mockedDao") MockedParkingDataAccessService parkingDataAccessService){
        this.parkingDataAccessService = parkingDataAccessService;
    }

    public List<Parking> getAllParkings() {
        return parkingDataAccessService.getAllEntries();
    }

    public void addNewParking(Parking parkingData) {
        UUID newParkingId = UUID.randomUUID();
        Timestamp enterTime = parkingData.getEntryTime()==null ? new Timestamp(System.currentTimeMillis()) : parkingData.getEntryTime();
        Parking newParking = new Parking(newParkingId, enterTime, parkingData.getExitTime(), parkingData.getPrice());
        parkingDataAccessService.addNewParking(newParking);
    }

    public String getPrice(UUID parkingId){
        return parkingDataAccessService.getPrice(parkingId) ;
    }

    public void updateParking(UUID parkingId, Parking parking) {
        Parking newParking = new Parking(parkingId, parking.getEntryTime(), parking.getExitTime(), parking.getPrice());
        parkingDataAccessService.updateParking(parkingId, newParking);
    }

    public void deleteParking(UUID parkingId) {
        parkingDataAccessService.deleteParkingById(parkingId);
    }

}
