package com.doctorreservation.demo.service.models;

import com.doctorreservation.demo.adapter.entity.Doctor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Setter
@Getter
public class DoctorModel {

    @JsonIgnore
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String speciality;

    @NonNull
    private String address;

    @NonNull
    private String education;


    public Doctor modelToDoctor() {
        Doctor doctor = new Doctor();
        doctor.setDoctorId(this.id);
        doctor.name(this.name).speciality(this.speciality).address(this.address)
                .education(this.education);
        return doctor;
    }

}
