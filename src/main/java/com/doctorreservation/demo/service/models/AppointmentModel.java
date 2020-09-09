package com.doctorreservation.demo.service.models;

import com.doctorreservation.demo.adapter.entity.Appointment;
import com.doctorreservation.demo.adapter.entity.Doctor;
import com.doctorreservation.demo.adapter.entity.Patient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class AppointmentModel {

    @JsonIgnore
    private long id;

    private String date;

    private long doctorId;

    private PatientModel patient;

    public Appointment modelToAppointment(Doctor doctor, Patient patient) {
        Appointment appointment = new Appointment();
        appointment.date(Date.valueOf(date))
                .patient(patient)
                .doctor(doctor);
        return appointment;
    }
}


