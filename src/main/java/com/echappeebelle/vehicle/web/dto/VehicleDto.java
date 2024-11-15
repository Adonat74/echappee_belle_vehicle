package com.echappeebelle.vehicle.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// A DTO (Data Transfer Object) is a simple object used to transfer data between layers, typically without any business logic.
@NoArgsConstructor
@Setter
@Getter
public class VehicleDto {
    private int idVehicle;
    private String type;
    private String plateNumber;
    private String brand;
    private String model;
    private String color;
    private int bookingPriceInCents;
    private int pricePerKilometerInCents;
    private int taxHorses;
    private int displacementInCm3;
    private int volumeInM3;
}
