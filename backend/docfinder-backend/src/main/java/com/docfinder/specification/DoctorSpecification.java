package com.docfinder.specification;

import com.docfinder.entity.Doctor;
import org.springframework.data.jpa.domain.Specification;

public class DoctorSpecification {

    public static Specification<Doctor> hasName(String name) {
        return (root, query, criteriaBuilder) -> {

            if (name == null || name.trim().isEmpty()) {
                return null;
            }

            return criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("user").get("name")),
                    "%" + name.trim().toLowerCase() + "%"
            );
        };
    }

    public static Specification<Doctor> hasCity(String city) {
        return (root, query, criteriaBuilder) -> {

            if (city == null || city.trim().isEmpty()) {
                return null;
            }

            return criteriaBuilder.equal(
                    criteriaBuilder.lower(root.get("city")),
                    city.trim().toLowerCase()
            );
        };
    }

    public static Specification<Doctor> hasSpecialization(Long specializationId) {
        return (root, query, criteriaBuilder) -> {

            if (specializationId == null) {
                return null;
            }

            return criteriaBuilder.equal(
                    root.get("specialization").get("id"),
                    specializationId
            );
        };
    }

    public static Specification<Doctor> hasMinimumExperience(Integer experience) {
        return (root, query, criteriaBuilder) -> {

            if (experience == null) {
                return null;
            }

            return criteriaBuilder.greaterThanOrEqualTo(
                    root.get("experience"),
                    experience
            );
        };
    }

    public static Specification<Doctor> isVerified(Boolean verified) {
        return (root, query, criteriaBuilder) -> {

            if (verified == null) {
                return null;
            }

            return criteriaBuilder.equal(
                    root.get("verified"),
                    verified
            );
        };
    }

    public static Specification<Doctor> hasQualification(String qualification) {
        return (root, query, criteriaBuilder) -> {

            if (qualification == null || qualification.trim().isEmpty()) {
                return null;
            }

            return criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("qualification")),
                    "%" + qualification.trim().toLowerCase() + "%"
            );
        };
    }
}