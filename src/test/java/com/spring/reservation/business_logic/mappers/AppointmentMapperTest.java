package com.spring.reservation.business_logic.mappers;

import com.spring.reservation.business_logic.io_schema.dto.AppointmentDto;
import com.spring.reservation.business_logic.service.DoctorService;
import com.spring.reservation.business_logic.service.PatientService;
import com.spring.reservation.database.DoctorRepository;
import com.spring.reservation.database.PatientRepository;
import com.spring.reservation.database.entity.Appointment;
import com.spring.reservation.database.entity.Doctor;
import com.spring.reservation.database.entity.Patient;
import com.spring.reservation.utils.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@Service
class AppointmentMapperTest {

    private Doctor doctor;
    private Patient patient;
    private Appointment appointment;


    @Mock
    private DoctorRepository doctorRepository;
    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private DoctorService doctorService;

    @InjectMocks
    private PatientService patientService;

    private AppointmentMapper appointmentMapper;





    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        doctor = new Doctor(){{
            setId(1);
            setName("doctorName");
            setSpeciality("eye");
            setAddress("Cairo");
            setEducation("Al-Azhar University");
        }};

        patient = new Patient(){
            {
                setId(1);
                setName("Saeed Fathy");
                setGender(Gender.MALE);
                setBirthdate(LocalDate.of(1980, 2,13));
            }};

        appointment = appointment = new Appointment(){{
            setDoctor(doctor);
            setPatient(patient);
            setBriefComplain("complain ...");
        }};

        appointmentMapper = new AppointmentMapper(doctorService, patientService);
    }

    @Test
    void convertDtoToAppointment() {

        when(doctorRepository.findById(doctor.getId()))
                .thenReturn(Optional.ofNullable(doctor));
        when(patientRepository.findById(patient.getId()))
                .thenReturn(Optional.ofNullable(patient));

        AppointmentDto dto = new AppointmentDto(1, 1, "complain");
        var appointment = appointmentMapper.convertDtoToAppointment(dto);

        assertNotNull(appointment.getDoctor());
        assertEquals(appointment.getDoctor().getId(), dto.doctorId());

        assertNotNull(appointment.getPatient());
        assertEquals(appointment.getPatient().getId(), dto.patientId());

        assertNotNull(appointment.getBriefComplain());
        assertEquals(appointment.getBriefComplain(), dto.briefComplain());
    }


    @Test
    void convertDtoToAppointmentThrows() {
        when(doctorRepository.findById(doctor.getId()))
                .thenReturn(Optional.ofNullable(doctor));
        when(patientRepository.findById(patient.getId()))
                .thenReturn(Optional.ofNullable(patient));

        assertThrows(NullPointerException.class,
                ()-> appointmentMapper.convertDtoToAppointment(null));

    }


    @Test
    void convertAppointmentToAppointmentView() {

        var appointmentView =
                AppointmentMapper.toView(appointment);

        assertNotNull(appointmentView.doctorName());
        assertEquals(appointmentView.doctorName(), appointment.getDoctor().getName());

        assertNotNull(appointmentView.speciality());
        assertEquals(appointmentView.speciality(), appointment.getDoctor().getSpeciality());


        assertNotNull(appointmentView.date());
        assertEquals(appointmentView.date(), appointment.getDate().toString());
    }

    @Test
    void convertAppointmentToAppointmentResponseThrows() {
        assertThrows(NullPointerException.class,
                ()-> AppointmentMapper.toView(null));
    }


}