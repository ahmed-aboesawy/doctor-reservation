package com.doctorreservation.demo.adapter.web.rest_api;

import com.doctorreservation.demo.adapter.entity.Patient;
import com.doctorreservation.demo.service.businesslogic.PatientServiceImpl;
import com.doctorreservation.demo.service.models.PatientModel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/patients/")
public class PatientController {

    private final PatientServiceImpl patientCrudService;

    public PatientController(PatientServiceImpl patientCrudService) {
        this.patientCrudService = patientCrudService;
    }

    @GetMapping
    @PreAuthorize(value = "hasRole('ROLE_USER')")
    public List<Patient> findPatients() {
        return patientCrudService.findAll();
    }

    @GetMapping("{id}")
    @PreAuthorize(value = "hasRole('ROLE_USER')")
    public Patient getPatient(@PathVariable long id) {
        return patientCrudService.findById(id);
    }

    //put mapping  ......
    @PutMapping("update/{id}")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    public Patient updateWithPut(@PathVariable long id,
                                 @RequestBody PatientModel model) throws NoSuchElementException {
        if (patientCrudService.findById(id) != null) {
            model.setId(id);
            return patientCrudService.save(model);
        }

        throw new NoSuchElementException();
    }

    //delete mapping ....
    @DeleteMapping("delete/{id}")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    public void delete(@PathVariable long id) {
        patientCrudService.deleteById(id);
    }

}
