package com.doctorreservation.demo.service.businesslogic;

import com.doctorreservation.demo.adapter.database.AppointmentRepository;
import com.doctorreservation.demo.adapter.entity.Appointment;
import com.doctorreservation.demo.adapter.entity.Doctor;
import com.doctorreservation.demo.adapter.entity.Patient;
import com.doctorreservation.demo.service.models.AppointmentModel;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class AppointmentServiceImpl extends CrudService<Appointment> {

    private final AppointmentRepository repository;
    private final PatientServiceImpl patientService;
    private final DoctorServiceImpl doctorService;

    public AppointmentServiceImpl(AppointmentRepository repository,
                                  PatientServiceImpl patientService,
                                  DoctorServiceImpl doctorService) {
        super(repository);
        this.repository = repository;
        this.patientService = patientService;
        this.doctorService = doctorService;
    }

    public Iterable<Appointment> findAllByDate(String date) {
        return repository.findAllByDate(Date.valueOf(date));
    }

    public Appointment save(AppointmentModel model) {

        Patient patient = patientService.save(model.getPatient());

        Doctor doctor = doctorService.findById(model.getDoctorId());

        Appointment appointment = model.modelToAppointment(doctor, patient);

        return super.save(appointment);
    }


}


