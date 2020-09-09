package com.doctorreservation.demo.adapter.web.rest_api;

import com.doctorreservation.demo.adapter.entity.Appointment;
import com.doctorreservation.demo.service.businesslogic.AppointmentServiceImpl;
import com.doctorreservation.demo.service.models.AppointmentModel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments/")
public class AppointmentController {

    private AppointmentServiceImpl appointmentService;

    public AppointmentController(AppointmentServiceImpl appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    @PreAuthorize(value = "hasRole('ROLE_USER')")
    public Iterable<Appointment> allPatientAppointments(@RequestParam(required = false, name = "date") String date) {
        if (date != null)
            return appointmentService.findAllByDate(date);
        return appointmentService.findAll();
    }

    @GetMapping("{id}")
    @PreAuthorize(value = "hasRole('ROLE_USER')")
    public Appointment findAppoint(@PathVariable long id) {
        return appointmentService.findById(id);
    }

    @PostMapping("save")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    public Appointment save(@RequestBody AppointmentModel model) {
        return appointmentService.save(model);
    }

    @DeleteMapping("delete/{id}")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    public void delete(@PathVariable long id) {
        appointmentService.deleteById(id);
    }

}
