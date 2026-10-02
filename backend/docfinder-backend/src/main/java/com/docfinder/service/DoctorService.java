package com.docfinder.service;

import com.docfinder.entity.Doctor;
import com.docfinder.repository.DoctorRepository;
import com.docfinder.specification.DoctorSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Get doctor by user ID
    public Optional<Doctor> getDoctorByUserId(Long userId) {
        return doctorRepository.findByUserId(userId);
    }

    // Get doctors by city
    public List<Doctor> getDoctorsByCity(String city) {
        return doctorRepository.findByCityIgnoreCase(city);
    }

    // Get doctors by specialization
    public List<Doctor> getDoctorsBySpecialization(Long specializationId) {
        return doctorRepository.findBySpecializationId(specializationId);
    }

    // Get verified doctors
    public List<Doctor> getVerifiedDoctors() {
        return doctorRepository.findByVerifiedTrue();
    }

    // Search and filter doctors
    public List<Doctor> searchDoctors(
            String name,
            String city,
            Long specializationId,
            Integer minimumExperience,
            Boolean verified,
            String qualification
    ) {

        Specification<Doctor> specification = Specification.allOf(
                DoctorSpecification.hasName(name),
                DoctorSpecification.hasCity(city),
                DoctorSpecification.hasSpecialization(specializationId),
                DoctorSpecification.hasMinimumExperience(minimumExperience),
                DoctorSpecification.isVerified(verified),
                DoctorSpecification.hasQualification(qualification)
        );

        return doctorRepository.findAll(specification);
    }
}