package com.spring.reservation.business_logic.service;

import com.spring.reservation.business_logic.io_schema.dto.DoctorDto;
import com.spring.reservation.business_logic.mappers.DoctorMapper;
import com.spring.reservation.database.DoctorRepository;
import com.spring.reservation.database.entity.Doctor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class DoctorServiceTest {

    private Doctor doctor;
    private Doctor savedDoctor;
    private Doctor updatedDoctor;

    private DoctorDto dto;
    private DoctorDto dtoUpdate;

    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private DoctorService doctorService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        doctor = new Doctor(){{
            setId(1);
            setName("Ali Omar");
            setEducation("Al-Azhar");
            setAddress("Giza");
            setSpeciality("eye");
        }};

        savedDoctor = new Doctor(){{
            setId(1);
            setName("Ali Omar");
            setEducation("Al-Azhar");
            setAddress("Giza");
            setSpeciality("eye");
        }};

        updatedDoctor = new Doctor(){{
            setId(1);
            setName("Ali Ahmed");
            setEducation("Al-Azhar University");
            setAddress("Cairo");
            setSpeciality("heart");
        }};

        dto = new DoctorDto("Ali Omar", "eye", "Giza", "Al-Azhar");
        dtoUpdate = new DoctorDto(
                "Ali Ahmed",
                "heart",
                "Cairo",
                "Al-Azhar University");
    }


    @Test
    void findById() {
        when(this.doctorRepository.findById(1))
                .thenReturn(Optional.ofNullable(doctor));
        Doctor doctor1 = this.doctorService.findById(1);
        assertEquals(doctor1, doctor);
    }

    @Test
    void findById_When_Value_Is_Null() {
        when(this.doctorRepository.findById(null))
                .thenThrow(new NoSuchElementException("No Doctor with ID: " + doctor.getId()));
    }

    @Test
    void save() {


        Doctor converted = DoctorMapper.convertDtoToDoctor(dto);
        DoctorDto dto1 = DoctorMapper.convertDoctorToDto(converted);

        assertEquals(doctor, savedDoctor);
        assertEquals(dto1, dto);

        when(this.doctorRepository.save(doctor))
                .thenReturn(savedDoctor);

        Doctor saved = doctorRepository.save(doctor);

        when(this.doctorService.save(dto))
                .thenReturn(converted);

        assertEquals(saved.getId(), doctor.getId());
        assertEquals(saved.getName(), converted.getName());
        assertEquals(saved.getAddress(), converted.getAddress());
        assertEquals(saved.getEducation(), converted.getEducation());
        assertEquals(saved.getSpeciality(), converted.getSpeciality());


    }

    @Test
    void update() {

        Doctor doctor1 = DoctorMapper.convertDtoToDoctor(dtoUpdate);
        doctor1.setId(1);

        when( this.doctorRepository.save(doctor1) ).thenReturn(updatedDoctor);

        Doctor doctor2 = this.doctorRepository.save(doctor1);

        DoctorDto dto1 = DoctorMapper.convertDoctorToDto(doctor2);

        assertEquals(doctor2, updatedDoctor);
        assertEquals(dto1, dtoUpdate);


    }
}