package com.echappeebelle.vehicle.web.repository;

import com.echappeebelle.vehicle.web.model.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VehicleRepository extends JpaRepository <Vehicle, Integer>, JpaSpecificationExecutor<Vehicle> {

}
