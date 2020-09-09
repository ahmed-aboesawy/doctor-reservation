package com.doctorreservation.demo.adapter.database;

import com.doctorreservation.demo.adapter.entity.Doctor;


public interface DoctorRepository extends MyRepository<Doctor> {
    Iterable<Doctor> findAllByDoctorManager_DoctorId(Long managerId);

}
