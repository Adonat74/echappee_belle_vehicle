package com.echappeebelle.vehicle.web.model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicles")
@DiscriminatorValue("UtilityVehicle")
public class UtilityVehicle extends Vehicle {


    private int volumeInM3; // attribut propre aux véhicules utilitaires

    public UtilityVehicle() {

    }

    public UtilityVehicle (int idVehicle, String plateNumber, String brand, String model, String color, int bookingPriceInCents, int pricePerKilometerInCents, int taxHorses, int volumeInM3) {
        super(idVehicle, plateNumber, brand, model, color, bookingPriceInCents, pricePerKilometerInCents, taxHorses);

        this.volumeInM3 = volumeInM3;
    }


    public int getVolumeInM3() {
        return volumeInM3;
    }

    public void setVolumeInM3(int volumeInM3) {
        this.volumeInM3 = volumeInM3;
    }
}
