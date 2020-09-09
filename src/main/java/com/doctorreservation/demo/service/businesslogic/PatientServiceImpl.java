package com.doctorreservation.demo.service.businesslogic;


import com.doctorreservation.demo.adapter.database.PatientRepository;
import com.doctorreservation.demo.adapter.entity.Patient;
import com.doctorreservation.demo.service.models.PatientModel;
import org.springframework.stereotype.Service;


@Service
public class PatientServiceImpl extends CrudService<Patient> {

    private final PatientRepository repository;

    public PatientServiceImpl(PatientRepository repository) {
        super(repository);
        this.repository = repository;
    }


    public Patient save(PatientModel model) {
        Patient patient = model.modelToPatient();
        return super.save(patient);
    }

}
