package com.echappeebelle.vehicle.web.model.finalPrice;

public class FinalPrice {

    private int vehicleId;
    private int nbKilometers;

    public FinalPrice(int vehicleId, int nbKilometers) {
        this.vehicleId = vehicleId;
        this.nbKilometers = nbKilometers;
    }

    public FinalPrice() {}


    public int getVehicleId() {
        return vehicleId;
    }
    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
    public int getNbKilometers() {
        return nbKilometers;
    }
    public void setNbKilometers(int nbKilometers) {
        this.nbKilometers = nbKilometers;
    }
}
