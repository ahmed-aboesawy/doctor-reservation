package com.doctorreservation.demo.service.models;

import com.doctorreservation.demo.adapter.entity.Gender;
import com.doctorreservation.demo.adapter.entity.Patient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class PatientModel {

    @JsonIgnore
    private long id;

    private String name;

    private String birthdate;

    private Gender gender;

    public Patient modelToPatient() {
        Patient patient = new Patient();
        patient.setId(this.id);
        patient.name(this.name).birthdate(Date.valueOf(this.birthdate)).gender(this.gender);
        return patient;
    }


}







