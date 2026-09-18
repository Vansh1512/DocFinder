package com.docfinder.repository;

import com.docfinder.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findByUserId(Long userId);

    List<Doctor> findByCityIgnoreCase(String city);

    List<Doctor> findBySpecializationId(Long specializationId);

    List<Doctor> findByVerifiedTrue();
}