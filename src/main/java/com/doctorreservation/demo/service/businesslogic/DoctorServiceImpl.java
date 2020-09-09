package com.doctorreservation.demo.service.businesslogic;

import com.doctorreservation.demo.adapter.database.DoctorRepository;
import com.doctorreservation.demo.adapter.entity.Doctor;
import com.doctorreservation.demo.service.models.DoctorModel;
import org.springframework.stereotype.Service;


@Service
public class DoctorServiceImpl extends CrudService<Doctor> {

    private final DoctorRepository repository;


    public DoctorServiceImpl(DoctorRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Iterable<Doctor> getManagerList(long managerId) {
        return repository.findAllByDoctorManager_DoctorId(managerId);
    }

    public Doctor save(DoctorModel doctorModel, Long managerId) {
        Doctor doctor = null;
        doctor = doctorModel.modelToDoctor();
        if (managerId != null) {
            Doctor manager = super.findById(managerId);
            doctor.doctorManager(manager);
        }
        return repository.save(doctor);
    }

}


