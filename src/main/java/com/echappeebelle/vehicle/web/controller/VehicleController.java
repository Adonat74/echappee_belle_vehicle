package com.echappeebelle.vehicle.web.controller;

import com.echappeebelle.vehicle.web.dto.VehicleDto;
import com.echappeebelle.vehicle.web.mapper.VehicleMapper;
import com.echappeebelle.vehicle.web.model.vehicle.Vehicle;
import com.echappeebelle.vehicle.web.service.vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class VehicleController {

    @Autowired
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }



    // The @GetMapping annotation maps HTTP GET requests to the method below
    @GetMapping("/vehicles")
    public ResponseEntity<List<VehicleDto>> listVehicles(
            @RequestParam(required = false) String type,    // Request parameter 'type' is optional (e.g., Car, TwoWheeler)
            @RequestParam(required = false) String brand,   // Request parameter 'brand' is optional (e.g., Toyota, Honda)
            @RequestParam(required = false) String model    // Request parameter 'model' is optional (e.g., Corolla, Civic)
    ) {
        // Call to the service layer to find vehicles based on the provided filters (type, brand, model)
        List<Vehicle> vehicles = vehicleService.findAll(type, brand, model);

        // Convert the list of Vehicle entities into a list of VehicleDto using the VehicleMapper class
        List<VehicleDto> vehicleDtos = vehicles.stream()
                .map(VehicleMapper::toDto) // Maps each Vehicle to a VehicleDto using the toDto method
                .toList(); // Collects all mapped VehicleDto objects into a list

        // Return the list of VehicleDto wrapped in a ResponseEntity with an HTTP 200 OK status
        return ResponseEntity.ok(vehicleDtos);
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
