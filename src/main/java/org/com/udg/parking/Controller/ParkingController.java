package org.com.udg.parking.Controller;

import org.com.udg.parking.Models.ParkingModel;
import org.com.udg.parking.Services.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/parking")
public class ParkingController {
    @Autowired
    ParkingService service;

    @PostMapping()
    public ParkingModel saveStudent(@RequestBody ParkingModel parking){
        return service.saveParking(parking);
    }

    @PutMapping()
    public ParkingModel editStudent(@RequestBody ParkingModel parking){
        return service.editParking(parking);
    }

    @GetMapping()
    public ArrayList<ParkingModel> vehicles(){
        return service.vehicles();
    }


    @GetMapping("/findParkingById/{id}")
    public Optional<ParkingModel> findParkingById(@PathVariable Long id){
        return service.findParkingById(id);
    }

    @GetMapping("/findParkingBymodelo/{modelo}")
    public Optional<ArrayList<ParkingModel>> findParkingBymodelo(@PathVariable String modelo){
        return service.findParkingBymodelo(modelo);
    }

    @GetMapping("/findParkingByccolor/{ccolor}")
    public Optional<ArrayList<ParkingModel>> findParkingByccolor(@PathVariable String ccolor){
        return service.findParkingByccolor(ccolor);
    }
    @DeleteMapping("/delete-parking-by-id")
    public String deleteParkingById(@RequestParam("id") Long id){
        return service.deleteParkingById(id);
    }
}
