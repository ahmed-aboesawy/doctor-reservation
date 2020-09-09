package com.doctorreservation.demo.adapter.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table
@Getter
public class Patient extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date birthdate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Patient name(String name) {
        this.name = name;
        return this;
    }

    public Patient birthdate(Date birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public Patient gender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public void setId(long id) {
        this.id = id;
    }
}
