package com.doctorreservation.demo.adapter.web.rest_api;


import com.doctorreservation.demo.adapter.entity.Doctor;
import com.doctorreservation.demo.service.businesslogic.DoctorServiceImpl;
import com.doctorreservation.demo.service.models.DoctorModel;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/doctors/")
@AllArgsConstructor
public class DoctorController {


    private final DoctorServiceImpl doctorService;


    @GetMapping
    @PreAuthorize(value = "hasRole('ROLE_USER')")
    public Iterable<Doctor> findManagerList(@RequestParam(required = false, name = "managerId") Long managerId) {
        if (managerId != null)
            return doctorService.getManagerList(managerId);
        else
            return doctorService.findAll();
    }


    @GetMapping("find/{id}")
    @PreAuthorize(value = "hasRole('ROLE_USER')")
    public Doctor findDoctor(@PathVariable long id) {
        return doctorService.findById(id);
    }


    @PostMapping("save")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    public ResponseEntity<Doctor> save(@RequestParam(required = false, name = "managerId") Long managerId,
                                       @RequestBody @Validated DoctorModel model) {
        return ResponseEntity.ok(doctorService.save(model, managerId));
    }


    @PutMapping("put-update/{id}")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    public Doctor fullUpdate(@PathVariable long id,
                             @RequestBody DoctorModel model,
                             @RequestParam Long managerId) throws NoSuchElementException {
        if (doctorService.findById(id) != null) {
            model.setId(id);
            return doctorService.save(model, managerId);
        }
        throw new NoSuchElementException("No such doctor with id:  " + id);

    }

    @PatchMapping("patch-update/{id}")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    public Doctor update(@PathVariable(name = "id") long id,
                         @RequestBody DoctorModel model,
                         @RequestParam(required = false, name = "managerId") Long managerId) throws NoSuchElementException {
        Doctor current = doctorService.findById(id);
        if (current != null) {
            model.setId(id);
            if (model.getName() == null)
                model.setName(current.getName());
            if (model.getAddress() == null)
                model.setAddress(current.getAddress());
            if (model.getEducation() == null)
                model.setEducation(current.getEducation());
            if (model.getSpeciality() == null)
                model.setSpeciality(current.getSpeciality());

            return doctorService.save(model, managerId);
        }
        throw new NoSuchElementException("No such doctor with id:  " + id);

    }


    @DeleteMapping("delete/{id}")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    public ResponseEntity<Doctor> delete(@PathVariable long id) {
        doctorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}








