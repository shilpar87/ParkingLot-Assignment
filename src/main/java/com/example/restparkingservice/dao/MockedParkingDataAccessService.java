package com.example.restparkingservice.dao;

import com.example.restparkingservice.model.Parking;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.*;

@Repository("mockedDao")
public class MockedParkingDataAccessService implements ParkingDao {
    private static final List<Parking> DB = new ArrayList<>();

    public List<Parking> getAllEntries() {
        return DB;
    }

    @Override
    public void addNewParking(Parking parking) {
        DB.add(parking);
    }

    @Override
    public String getPrice(UUID parkingId) {
        String ret = "";
        Parking parking =  DB.stream().filter(entry -> parkingId.equals(entry.getID())).findFirst().orElse(null);
        if(parking!=null){
            int price = parking.getPrice();
            int dollars = price/100;
            ret = dollars+"."+(price-dollars)%100;
        }
        return ret;
    }

    @Override
    public void updateParking(UUID parkingId, Parking parking){
        DB.removeIf(obj -> parkingId.equals(obj.getID()));
        DB.add(parking);
    }

    @Override
    public void deleteParkingById (UUID id) {
        DB.removeIf(obj -> id.equals(obj.getID()));
    }

}
