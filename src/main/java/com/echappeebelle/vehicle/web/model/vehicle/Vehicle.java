package com.echappeebelle.vehicle.web.model.vehicle;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;

// Enables polymorphic serialization/deserialization in JSON for subclasses of Vehicle.
// 'type' property in JSON will indicate the subclass name (e.g., "Car", "TwoWheeler", "UtilityVehicle").
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Car.class, name = "Car"),
        @JsonSubTypes.Type(value = TwoWheeler.class, name = "TwoWheeler"),
        @JsonSubTypes.Type(value = UtilityVehicle.class, name = "UtilityVehicle"),
})

@Entity // Indicates that this class is a JPA entity, mapping it to a database table.
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Configures all subclasses to be stored in a single table.
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
// Specifies the column ('type') that will store the subclass type to differentiate among subclasses in a single table.
@Table(name = "vehicles") // Maps the entity to the 'vehicles' table in the database.
public abstract class Vehicle{

    @Id // Marks 'idVehicle' as the primary key for this entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configures 'idVehicle' to auto-increment as new records are created.
    @Column(name = "id_vehicle", unique = true, nullable = false)  // Specifies the column's properties, ensuring it is unique and cannot be null.
    private int idVehicle;

    // Declares other basic properties of the vehicle, which are common to all subclasses.
    private String plateNumber;
    private String brand;
    private String model;
    private String color;
    private int bookingPriceInCents;
    private int pricePerKilometerInCents;
    private int taxHorses;

    // Maps the 'type' field to the discriminator column for read-only purposes.
    // 'insertable = false, updatable = false' prevents conflicts since Hibernate controls this column.
    @Column(name = "type", insertable = false, updatable = false)
    private String type;

    // Default constructor, needed by JPA.
    public Vehicle() {
    }

    // Constructor to initialize all properties when creating a new Vehicle instance.
    public Vehicle(int idVehicle, String plateNumber, String brand, String model, String color,
                   int bookingPriceInCents, int pricePerKilometerInCents, int taxHorses) {
        this.idVehicle = idVehicle;
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.bookingPriceInCents = bookingPriceInCents;
        this.pricePerKilometerInCents = pricePerKilometerInCents;
        this.taxHorses = taxHorses;
    }

    // Getter and setter methods for each field.
    // These allow controlled access and modification of the fields by other classes.

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
