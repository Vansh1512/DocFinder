package com.docfinder.service;
import com.docfinder.entity.Review;
import com.docfinder.dto.DoctorResponse;
import com.docfinder.entity.Doctor;
import com.docfinder.repository.DoctorRepository;
import com.docfinder.specification.DoctorSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.docfinder.repository.ReviewRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final ReviewRepository reviewRepository;

    public DoctorService(
            DoctorRepository doctorRepository,
            ReviewRepository reviewRepository) {

        this.doctorRepository = doctorRepository;
        this.reviewRepository = reviewRepository;
    }

    // Get all doctors
    public List<DoctorResponse> getAllDoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    // Get doctor by user ID
    public Optional<DoctorResponse> getDoctorByUserId(Long userId) {
        return doctorRepository.findByUserId(userId)
                .map(this::convertToResponse);
    }

    // Get doctors by city
    public List<DoctorResponse> getDoctorsByCity(String city) {
        return doctorRepository.findByCityIgnoreCase(city)
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    // Get doctors by specialization
    public List<DoctorResponse> getDoctorsBySpecialization(Long specializationId) {
        return doctorRepository.findBySpecializationId(specializationId)
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    // Get verified doctors
    public List<DoctorResponse> getVerifiedDoctors() {
        return doctorRepository.findByVerifiedTrue()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    // Search and filter doctors
    public List<DoctorResponse> searchDoctors(
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

        return doctorRepository.findAll(specification)
                .stream()
                .map(this::convertToResponse)
                .toList();
    }
    private Double calculateAverageRating(Long doctorId) {

        List<Review> reviews = reviewRepository.findByDoctorId(doctorId);

        if (reviews.isEmpty()) {
            return null;
        }

        double total = 0;

        for (Review review : reviews) {
            total += review.getRating();
        }

        return Math.round((total / reviews.size()) * 100.0) / 100.0;
    }
    // Convert Doctor entity to safe DoctorResponse DTO
    private DoctorResponse convertToResponse(Doctor doctor) {

        String specializationName = null;

        if (doctor.getSpecialization() != null) {
            specializationName = doctor.getSpecialization().getName();
        }

        String doctorName = null;
        String email = null;

        if (doctor.getUser() != null) {
            doctorName = doctor.getUser().getName();
            email = doctor.getUser().getEmail();
        }

        return new DoctorResponse(
                doctor.getId(),
                doctorName,
                email,
                doctor.getPhone(),
                doctor.getQualification(),
                doctor.getExperience(),
                specializationName,
                doctor.getClinicName(),
                doctor.getClinicAddress(),
                doctor.getCity(),
                doctor.getVerified(),
                calculateAverageRating(doctor.getId())
        );
    }
}