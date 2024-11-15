package com.echappeebelle.vehicle.web.mapper;

import com.echappeebelle.vehicle.web.dto.VehicleDto;
import com.echappeebelle.vehicle.web.model.vehicle.Car;
import com.echappeebelle.vehicle.web.model.vehicle.TwoWheeler;
import com.echappeebelle.vehicle.web.model.vehicle.UtilityVehicle;
import com.echappeebelle.vehicle.web.model.vehicle.Vehicle;

public class VehicleMapper {
    public static VehicleDto toDto(Vehicle vehicle) {
        VehicleDto dto = new VehicleDto();
        dto.setIdVehicle(vehicle.getIdVehicle());
        dto.setPlateNumber(vehicle.getPlateNumber());
        dto.setBrand(vehicle.getBrand());
        dto.setModel(vehicle.getModel());
        dto.setColor(vehicle.getColor());
        dto.setBookingPriceInCents(vehicle.getBookingPriceInCents());
        dto.setPricePerKilometerInCents(vehicle.getPricePerKilometerInCents());
        dto.setTaxHorses(vehicle.getTaxHorses());

        // Determine the type based on the instance or discriminator
        if (vehicle instanceof Car) {
            dto.setType("Car");
        } else if (vehicle instanceof TwoWheeler) {
            dto.setType("TwoWheeler");
            TwoWheeler twoWheeler = (TwoWheeler) vehicle;
            dto.setDisplacementInCm3(twoWheeler.getDisplacementInCm3());
        } else if (vehicle instanceof UtilityVehicle) {
            dto.setType("UtilityVehicle");
            UtilityVehicle utilityVehicle = (UtilityVehicle) vehicle;
            dto.setDisplacementInCm3(utilityVehicle.getVolumeInM3());
        }

        return dto;
    }
}
