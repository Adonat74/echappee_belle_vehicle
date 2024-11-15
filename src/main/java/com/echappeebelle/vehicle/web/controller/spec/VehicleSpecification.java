package com.echappeebelle.vehicle.web.controller.spec;

import com.echappeebelle.vehicle.web.model.vehicle.Vehicle;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class VehicleSpecification {

    private VehicleSpecification() {}

    public static Specification<Vehicle> getVehiclesByCriteria(String type, String brand, String model) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (type != null && !type.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("type"), type));
            }
            if (brand != null && !brand.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("brand"), brand));
            }
            if (model != null && !model.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("model"), model));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
