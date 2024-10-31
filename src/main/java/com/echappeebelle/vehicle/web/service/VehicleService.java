package com.echappeebelle.vehicle.web.service;


import com.echappeebelle.vehicle.web.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService<T extends Vehicle> {
    List<T> findAll();
    Optional<T> findById(int id);
    T save(T vehicle);
    T update(int id, T vehicle);
    void deleteById(int id);
}
