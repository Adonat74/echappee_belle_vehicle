package com.echappeebelle.vehicle.web.controller.spec;

import com.echappeebelle.vehicle.web.model.vehicle.Vehicle;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

// A utility class that contains specifications for dynamically querying Vehicle entities
public class VehicleSpecification {

    // Private constructor to prevent instantiation of this utility class
    private VehicleSpecification() {}

    // Method to create a Specification based on optional filtering criteria (type, brand, model)
    public static Specification<Vehicle> getVehiclesByCriteria(String type, String brand, String model) {
        return (root, query, criteriaBuilder) -> {
            // List to hold the dynamic predicates based on the given criteria
            List<Predicate> predicates = new ArrayList<>();

            // Filter by vehicle type if type is provided (and not empty)
            if (type != null && !type.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("type"), type));
            }

            // Filter by brand if brand is provided (and not empty)
            if (brand != null && !brand.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("brand"), brand));
            }

            // Filter by model if model is provided (and not empty)
            if (model != null && !model.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("model"), model));
            }

            // Combine all predicates using AND logic
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
