package com.example.restparkingservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.UUID;

public class Parking {
    private final UUID parkingID;

    private final Timestamp entryTime;

    private Timestamp exitTime;

    private int price; // In cents


    public Parking(@JsonProperty("parkingId") UUID parkingID, @JsonProperty("entryTime") Timestamp entryTime, @JsonProperty("exitTime") Timestamp exitTime, @JsonProperty("price") int price) {
        this.parkingID = parkingID;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.price = price==0 ? getParkingTotal(entryTime, exitTime) : price;
    }

    public UUID getID() {
        return parkingID;
    }

    public Timestamp getEntryTime() {
        return entryTime;
    }

    public Timestamp getExitTime() {
        return exitTime;
    }

    public int getPrice() {
        return price;
    }

    public void setExitTime(Timestamp exitTime) {
        this.exitTime = exitTime;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private int getParkingTotal(Timestamp entryTime, Timestamp exitTime) {
        int rate = 0;
        long diff = exitTime.getTime() - entryTime.getTime();
        int hour   = (int) (( (diff < 0 ? 0 : diff) / (1000*60*60)) % 24);
        Calendar cal = Calendar.getInstance();
        cal.setTime(entryTime);
        int day = cal.get(Calendar.DAY_OF_WEEK);

        if(day == 0 || day == 6) {
            if(hour < 2) rate = 500;
            else if(hour <= 5) rate = 800;
            else if(hour <= 10) rate = 1200;
            else if(hour <= 15) rate = 1800;
            else if(hour <= 24) rate = 2500;
        }
        else {
            if(hour < 2) rate = 700;
            else if(hour <= 5) rate = 1000;
            else if(hour <= 10) rate = 1500;
            else if(hour <= 15) rate = 2200;
            else if(hour <= 24) rate = 3000;
        }

        return hour * rate;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "parkingId=" + parkingID +
                ", entryTime='" + entryTime + '\'' +
                ", exitTime='" + exitTime + '\'' +
                ", price=" + price +
                '}';
    }
}
