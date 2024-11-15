package com.echappeebelle.vehicle.web.service.vehicle;

import com.echappeebelle.vehicle.web.controller.spec.VehicleSpecification;
import com.echappeebelle.vehicle.web.model.vehicle.Vehicle;
import com.echappeebelle.vehicle.web.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> findAll(String type, String brand, String model) {
        return vehicleRepository.findAll(VehicleSpecification.getVehiclesByCriteria(type, brand, model));
    }

    public Optional<Vehicle> findById(int id) {
        return vehicleRepository.findById(id);
    }

    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }


    public Vehicle update(int id, Vehicle newVehicle) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);

        if (optionalVehicle.isPresent()) {
            Vehicle existingVehicle = optionalVehicle.get();

            // Update fields of the existing vehicle
            existingVehicle.setType(newVehicle.getType());
            existingVehicle.setPlateNumber(newVehicle.getPlateNumber());
            existingVehicle.setBrand(newVehicle.getBrand());
            existingVehicle.setModel(newVehicle.getModel());
            existingVehicle.setColor(newVehicle.getColor());
            existingVehicle.setBookingPriceInCents(newVehicle.getBookingPriceInCents());
            existingVehicle.setPricePerKilometerInCents(newVehicle.getPricePerKilometerInCents());
            existingVehicle.setTaxHorses(newVehicle.getTaxHorses());

            // Save the updated vehicle
            newVehicle = vehicleRepository.save(existingVehicle);

            return newVehicle;
        }
        return null;
    }


    public void deleteById(int id) {
        if (vehicleRepository.existsById(id)) {
            vehicleRepository.deleteById(id);
        } else {
            throw new RuntimeException("Book not found with id: " + id);
        }
    }
}
