package com.docfinder.dto;

public class DoctorResponse {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String qualification;
    private Integer experience;
    private String specialization;
    private String clinicName;
    private String clinicAddress;
    private String city;
    private Boolean verified;
    private Double averageRating;

    public DoctorResponse() {
    }

    public DoctorResponse(
            Long id,
            String name,
            String email,
            String phone,
            String qualification,
            Integer experience,
            String specialization,
            String clinicName,
            String clinicAddress,
            String city,
            Boolean verified,
            Double averageRating
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.qualification = qualification;
        this.experience = experience;
        this.specialization = specialization;
        this.clinicName = clinicName;
        this.clinicAddress = clinicAddress;
        this.city = city;
        this.verified = verified;
        this.averageRating = averageRating;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getQualification() {
        return qualification;
    }

    public Integer getExperience() {
        return experience;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getClinicName() {
        return clinicName;
    }

    public String getClinicAddress() {
        return clinicAddress;
    }

    public String getCity() {
        return city;
    }

    public Boolean getVerified() {
        return verified;
    }

    public Double getAverageRating() {
        return averageRating;
    }
}