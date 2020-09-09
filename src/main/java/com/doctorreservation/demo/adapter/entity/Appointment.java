package com.doctorreservation.demo.adapter.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table
@Getter
public class Appointment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Date date;

    @OneToOne(targetEntity = Patient.class)
    @JoinColumn
    private Patient patient;

    @OneToOne(targetEntity = Doctor.class)
    @JoinColumn
    @JsonIgnoreProperties(value = {"doctorManager","managerList"})
    private Doctor doctor;

    public Appointment date(Date date) {
        this.date = date;
        return this;
    }

    public Appointment patient(Patient patient) {
        this.patient = patient;
        return this;
    }

    public Appointment doctor(Doctor doctor) {
        this.doctor = doctor;
        return this;
    }
}
