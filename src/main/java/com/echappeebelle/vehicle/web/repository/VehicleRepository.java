package com.echappeebelle.vehicle.web.repository;

import com.echappeebelle.vehicle.web.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository <Vehicle, Integer> {
}
