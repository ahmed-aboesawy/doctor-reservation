package com.doctorreservation.demo.adapter.database;

import com.doctorreservation.demo.adapter.entity.Appointment;

import java.sql.Date;

public interface AppointmentRepository extends MyRepository<Appointment>{

    Iterable<Appointment> findAllByDate(Date date);
}
