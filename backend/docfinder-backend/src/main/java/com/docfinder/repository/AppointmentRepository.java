package com.docfinder.repository;

import com.docfinder.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository
        extends JpaRepository<Appointment, Long> {

    List<Appointment> findByPatientId(Long patientId);

    List<Appointment> findByDoctorId(Long doctorId);

    List<Appointment> findByPatientIdAndStatus(
            Long patientId,
            String status
    );

    List<Appointment> findByDoctorIdAndStatus(
            Long doctorId,
            String status
    );
}