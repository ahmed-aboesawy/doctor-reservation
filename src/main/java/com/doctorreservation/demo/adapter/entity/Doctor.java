package com.doctorreservation.demo.adapter.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table
@Getter
public class Doctor extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctorId")
    private Long doctorId;

    @Column(name = "name")
    private String name;

    @Column(name = "speciality")
    private String speciality;

    @Column(name = "address")
    private String address;

    @Column(name = "education")
    private String education;

    @ManyToOne(targetEntity = Doctor.class)
    @JoinColumn(referencedColumnName = "doctorId")
    @JsonBackReference
    private Doctor doctorManager;

    @OneToMany(mappedBy = "doctorManager", targetEntity = Doctor.class)
    private List<Doctor> managerList;

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Doctor name(String name) {
        this.name = name;
        return this;
    }

    public Doctor speciality(String speciality) {
        this.speciality = speciality;
        return this;
    }

    public Doctor address(String address) {
        this.address = address;
        return this;
    }

    public Doctor education(String education) {
        this.education = education;
        return this;
    }

    public Doctor doctorManager(Doctor doctorManager) {
        this.doctorManager = doctorManager;
        return this;
    }

    public Doctor managerList(List<Doctor> managerList) {
        this.managerList = managerList;
        return this;
    }
}
