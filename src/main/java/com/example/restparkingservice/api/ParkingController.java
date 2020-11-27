package com.example.restparkingservice.api;

import com.example.restparkingservice.model.Parking;
import com.example.restparkingservice.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/parking")
public class ParkingController {

    private final ParkingService parkingService;

    @Autowired
    public ParkingController(ParkingService parkingService){
        this.parkingService = parkingService;
    }

    @GetMapping
    public List<Parking> getReport() {
        return parkingService.getAllParkings();
    }

    @PostMapping
    public void addNewParking(@RequestBody Parking parking) { parkingService.addNewParking(parking);}


    @GetMapping(path = "{parkingId}/price")
    public List<String> getPrice(
            @PathVariable("parkingId") UUID parkingId) {
        return Arrays.asList(parkingService.getPrice(parkingId));
    }

    @PutMapping(path = "{parkingId}")
    public void updateParking(@PathVariable("parkingId") UUID parkingId,
                              @RequestBody Parking parking) {
        parkingService.updateParking(parkingId, parking);
    }

    @DeleteMapping("{parkingId}")
    public void deleteParking(@PathVariable("parkingId") UUID parkingId) {
        parkingService.deleteParking(parkingId);
    }

}
