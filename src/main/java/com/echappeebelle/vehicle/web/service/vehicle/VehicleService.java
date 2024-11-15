package com.echappeebelle.vehicle.web.service.vehicle;


import com.echappeebelle.vehicle.web.model.vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService<T extends Vehicle> {
    List<T> findAll(String type, String brand, String model);
    Optional<T> findById(int id);
    T save(T vehicle);
    T update(int id, T vehicle);
    void deleteById(int id);
}
