package com.docfinder.repository;

import com.docfinder.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository
        extends JpaRepository<Doctor, Long>, JpaSpecificationExecutor<Doctor> {

    Optional<Doctor> findByUserId(Long userId);

    List<Doctor> findByCityIgnoreCase(String city);

    List<Doctor> findBySpecializationId(Long specializationId);

    List<Doctor> findByVerifiedTrue();

    List<Doctor> findByCityIgnoreCaseAndVerifiedTrue(String city);

    List<Doctor> findBySpecializationIdAndVerifiedTrue(Long specializationId);

    List<Doctor> findByCityIgnoreCaseAndSpecializationId(
            String city,
            Long specializationId
    );

    List<Doctor> findByCityIgnoreCaseAndSpecializationIdAndVerifiedTrue(
            String city,
            Long specializationId
    );

    List<Doctor> findByExperienceGreaterThanEqual(Integer experience);

    List<Doctor> findByExperienceLessThanEqual(Integer experience);

    List<Doctor> findByClinicNameContainingIgnoreCase(String clinicName);

    List<Doctor> findByQualificationContainingIgnoreCase(String qualification);

    List<Doctor> findByUserNameContainingIgnoreCase(String name);

    List<Doctor> findByUserEmailIgnoreCase(String email);
}