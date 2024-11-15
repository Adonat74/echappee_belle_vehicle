package com.echappeebelle.vehicle.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
