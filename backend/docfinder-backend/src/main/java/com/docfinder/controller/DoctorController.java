package com.docfinder.controller;

import com.docfinder.dto.DoctorResponse;
import com.docfinder.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // Get all doctors
    @GetMapping
    public List<DoctorResponse> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    // Search and filter doctors
    @GetMapping("/search")
    public List<DoctorResponse> searchDoctors(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Long specializationId,
            @RequestParam(required = false) Integer minimumExperience,
            @RequestParam(required = false) Boolean verified,
            @RequestParam(required = false) String qualification
    ) {

        return doctorService.searchDoctors(
                name,
                city,
                specializationId,
                minimumExperience,
                verified,
                qualification
        );
    }
}