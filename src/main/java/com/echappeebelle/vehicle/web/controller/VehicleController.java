package com.echappeebelle.vehicle.web.controller;

import com.echappeebelle.vehicle.web.model.vehicle.Vehicle;
import com.echappeebelle.vehicle.web.service.vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VehicleController {

    @Autowired
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    @GetMapping("/vehicles")
    public List<Vehicle> listVehicles() {
        return vehicleService.findAll();
    }

    @GetMapping(value = "/vehicles/{id}")
    public Optional<Vehicle> displayOneVehicle(@PathVariable int id) {
        return vehicleService.findById(id);
    }

    @PostMapping(value = "/vehicles")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.save(vehicle);
    }



    @PutMapping(value = "/vehicles/{id}")
    public Vehicle updateVehicle(@PathVariable int id, @RequestBody Vehicle vehicle) {
        return vehicleService.update(id, vehicle);
    }

    @DeleteMapping(value = "/vehicles/{id}")
    public void deleteVehicle(@PathVariable int id) {
        vehicleService.deleteById(id);
    }

}
