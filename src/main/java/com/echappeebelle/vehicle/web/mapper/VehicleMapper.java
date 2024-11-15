package com.echappeebelle.vehicle.web.mapper;

import com.echappeebelle.vehicle.web.dto.VehicleDto;
import com.echappeebelle.vehicle.web.model.vehicle.Car;
import com.echappeebelle.vehicle.web.model.vehicle.TwoWheeler;
import com.echappeebelle.vehicle.web.model.vehicle.UtilityVehicle;
import com.echappeebelle.vehicle.web.model.vehicle.Vehicle;

// A utility class to convert Vehicle entities into VehicleDto objects for data transfer
public class VehicleMapper {

    // Method to convert a Vehicle object into a VehicleDto
    public static VehicleDto toDto(Vehicle vehicle) {
        // Create a new instance of VehicleDto
        VehicleDto dto = new VehicleDto();

        // Set common fields that are present in all types of vehicles
        dto.setIdVehicle(vehicle.getIdVehicle());
        dto.setPlateNumber(vehicle.getPlateNumber());
        dto.setBrand(vehicle.getBrand());
        dto.setModel(vehicle.getModel());
        dto.setColor(vehicle.getColor());
        dto.setBookingPriceInCents(vehicle.getBookingPriceInCents());
        dto.setPricePerKilometerInCents(vehicle.getPricePerKilometerInCents());
        dto.setTaxHorses(vehicle.getTaxHorses());

        // Determine the specific type of vehicle and set type-specific properties
        if (vehicle instanceof Car) {
            // If the vehicle is a Car, set the type to "Car"
            dto.setType("Car");

        } else if (vehicle instanceof TwoWheeler) {
            // If the vehicle is a TwoWheeler, set the type to "TwoWheeler"
            dto.setType("TwoWheeler");
            // Cast the vehicle to TwoWheeler to access subclass-specific fields
            TwoWheeler twoWheeler = (TwoWheeler) vehicle;
            // Set the displacement in cm3 specific to a TwoWheeler
            dto.setDisplacementInCm3(twoWheeler.getDisplacementInCm3());

        } else if (vehicle instanceof UtilityVehicle) {
            // If the vehicle is a UtilityVehicle, set the type to "UtilityVehicle"
            dto.setType("UtilityVehicle");
            // Cast the vehicle to UtilityVehicle to access subclass-specific fields
            UtilityVehicle utilityVehicle = (UtilityVehicle) vehicle;
            // Set the volume in m3 specific to a UtilityVehicle
            dto.setVolumeInM3(utilityVehicle.getVolumeInM3());
        }
        // Return the populated DTO
        return dto;
    }
}
