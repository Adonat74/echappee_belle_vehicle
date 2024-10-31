package com.echappeebelle.vehicle.web.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;



@Entity
@Table(name = "vehicles")
@DiscriminatorValue("TwoWheeler")
public class TwoWheeler extends Vehicle {


    private int displacementInCm3; // attribut propre aux 2 roues.




    public TwoWheeler() {

    }


    public TwoWheeler (int idVehicle, String plateNumber, String brand, String model, String color, int bookingPriceInCents, int pricePerKilometerInCents, int taxHorses, int displacementInCm3) {
        super(idVehicle, plateNumber, brand, model, color, bookingPriceInCents, pricePerKilometerInCents, taxHorses);
        this.displacementInCm3 = displacementInCm3;
    }


    public int getDisplacementInCm3() {
        return displacementInCm3;
    }

    public void setDisplacementInCm3(int displacementInCm3) {
        this.displacementInCm3 = displacementInCm3;
    }
}
