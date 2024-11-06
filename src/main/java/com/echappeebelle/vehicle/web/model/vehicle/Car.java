package com.echappeebelle.vehicle.web.model.vehicle;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicles")
@DiscriminatorValue("Car")
public class Car extends Vehicle {


    public Car() {

    }


    public Car (int idVehicle, String plateNumber, String brand, String model, String color, int bookingPriceInCents, int pricePerKilometerInCents, int taxHorses) {
        super(idVehicle, plateNumber, brand, model, color, bookingPriceInCents, pricePerKilometerInCents, taxHorses);
    }


}

