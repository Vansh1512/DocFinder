package com.docfinder.repository;

import com.docfinder.entity.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvailabilityRepository
        extends JpaRepository<Availability, Long> {

    List<Availability> findByDoctorId(Long doctorId);

    List<Availability> findByDoctorIdAndDayOfWeekIgnoreCase(
            Long doctorId,
            String dayOfWeek
    );
}