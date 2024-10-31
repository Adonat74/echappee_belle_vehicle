package com.echappeebelle.vehicle.web.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Car.class, name = "Car"),
        @JsonSubTypes.Type(value = TwoWheeler.class, name = "TwoWheeler"),
        @JsonSubTypes.Type(value = UtilityVehicle.class, name = "UtilityVehicle"),
})

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "vehicles")
public abstract class Vehicle{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehicle", unique = true, nullable = false)  // Ensure this is unique in the hierarchy
    private int idVehicle;
    private String plateNumber;
    private String brand;
    private String model;
    private String color;
    private int bookingPriceInCents;
    private int pricePerKilometerInCents;
    private int taxHorses;
    @Column(name = "type", insertable = false, updatable = false) // Maps the discriminator column to the `type` field
    private String type;


    public Vehicle() {
    }


    public Vehicle (int idVehicle, String plateNumber, String brand, String model, String color, int bookingPriceInCents, int pricePerKilometerInCents, int taxHorses) {
        this.idVehicle = idVehicle;
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.bookingPriceInCents = bookingPriceInCents;
        this.pricePerKilometerInCents = pricePerKilometerInCents;
        this.taxHorses = taxHorses;
    }


    public int getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(int idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getBookingPriceInCents() {
        return bookingPriceInCents;
    }

    public void setBookingPriceInCents(int bookingPriceInCents) {
        this.bookingPriceInCents = bookingPriceInCents;
    }

    public int getPricePerKilometerInCents() {
        return pricePerKilometerInCents;
    }

    public void setPricePerKilometerInCents(int pricePerKilometerInCents) {
        this.pricePerKilometerInCents = pricePerKilometerInCents;
    }

    public int getTaxHorses() {
        return taxHorses;
    }

    public void setTaxHorses(int taxHorses) {
        this.taxHorses = taxHorses;
    }
}
