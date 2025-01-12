package com.spring.reservation.business_logic.mappers;

import com.spring.reservation.business_logic.io_schema.dto.PatientDto;
import com.spring.reservation.business_logic.io_schema.output.PatientResponse;
import com.spring.reservation.database.entity.Appointment;
import com.spring.reservation.database.entity.Doctor;
import com.spring.reservation.database.entity.Patient;
import com.spring.reservation.utils.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PatientMapperTest {
    private Patient patient;
    private Doctor doctor;
    private Appointment appointment;

    @BeforeEach
    void setUp() {
        patient = new Patient() {{
            setId(1);
            setName("name");
            setBirthdate(LocalDate.of(1997, 4, 3));
            setGender(Gender.MALE);
        }};
        doctor = new Doctor(){{
            setName("Ali Omar");
            setEducation("Al-Azhar");
            setAddress("Giza");
            setSpeciality("eye");
        }};
        appointment = new Appointment(){{
            setPatient(patient);
            setDoctor(doctor);
            setBriefComplain(" complain ........");
            setDate(LocalDateTime.now());
        }};
        patient.setAppointments(List.of(appointment,appointment, appointment));

    }

    @Test
    void convertPatientToResponse() {
        int age = LocalDate.now().getYear() - patient.getBirthdate().getYear();
        PatientResponse response = PatientMapper.convertPatientToResponse(patient);

        assertNotNull(response.patientName());
        assertNotNull(response.appointments());
        assertNotNull(response.gender());

        assertEquals(response.patientName(), patient.getName());
        assertEquals(response.age(), age);
        assertEquals(response.gender(), patient.getGender());
        assertEquals(response.appointments().size(), patient.getAppointments().size());

    }

    @Test
    void convertPatientToResponseThrows() {
        assertThrows(NullPointerException.class,
                () -> PatientMapper.convertPatientToResponse(null));
    }

    @Test
    void convertDtoToPatient() {
        PatientDto dto
                = new PatientDto("name", LocalDate.of(2021, 5, 4),Gender.MALE);
        Patient patient = new Patient();
                PatientMapper.convertDtoToPatient(dto, patient);
        assertNotNull(patient.getName());
        assertNotNull(patient.getBirthdate());
        assertNotNull(patient.getGender());

        assertEquals(dto.name(), patient.getName());
        assertEquals(dto.birthdate(), patient.getBirthdate());
        assertEquals(dto.gender(), patient.getGender());
    }

    @Test
    void convertDtoToPatientThrows() {
        assertThrows(NullPointerException.class,
                () -> PatientMapper.convertDtoToPatient(null, null));
    }
}