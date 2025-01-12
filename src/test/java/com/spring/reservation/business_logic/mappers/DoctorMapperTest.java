package com.spring.reservation.business_logic.mappers;

import com.spring.reservation.business_logic.io_schema.dto.DoctorDto;
import com.spring.reservation.database.entity.Doctor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorMapperTest {

    private Doctor doctor;

    @BeforeEach
    void setUp(){
        doctor = new Doctor(){
            {
                setName("Ali Omar");
                setSpeciality("blood");
                setEducation("YT...");
                setAddress("cairo");
            }};
    }

    @Test
    void convertDoctorToDto() {
        DoctorDto dto = DoctorMapper.convertDoctorToDto(doctor);

        assertNotNull(dto.name());
        assertEquals(dto.name(), doctor.getName());

        assertNotNull(dto.speciality());
        assertEquals(dto.speciality(), doctor.getSpeciality());

        assertNotNull(dto.education());
        assertEquals(dto.education(), doctor.getEducation());

        assertNotNull(dto.address());
        assertEquals(dto.address(), doctor.getAddress());
    }


    @Test
    void convertDoctorToDtoThrows() {
        assertThrows(NullPointerException.class,
                () -> DoctorMapper.convertDoctorToDto(null));
    }


    @Test
    void convertDtoToDoctor() {
        DoctorDto dto = new DoctorDto("Doctor Name", "Speciality", "Address", "Edu");
        Doctor doctor = DoctorMapper.convertDtoToDoctor(dto);
        assertNotNull(doctor.getName());
        assertEquals(dto.name(), doctor.getName());

        assertNotNull(doctor.getSpeciality());
        assertEquals(dto.speciality(), doctor.getSpeciality());

        assertNotNull(doctor.getEducation());
        assertEquals(dto.education(), doctor.getEducation());

        assertNotNull(doctor.getAddress());
        assertEquals(dto.address(), doctor.getAddress());
    }

    @Test
    void convertDtoToDoctorThrows() {
        assertThrows(NullPointerException.class,
                () -> DoctorMapper.convertDtoToDoctor(null));
    }
}