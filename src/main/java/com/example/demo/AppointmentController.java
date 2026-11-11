package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return service.getAllAppointments();
    }

    @GetMapping("/patient/{patientId}")
    public List<Appointment> getPatientAppointments(@PathVariable Integer patientId) {
        return service.getAppointmentsByPatient(patientId);
    }

    @PostMapping("/book")
    public Appointment bookAppointment(
            @RequestParam Integer patientId,
            @RequestParam Integer doctorId,
            @RequestParam(required = false) String apptDate) {
        LocalDateTime date = (apptDate != null) ? LocalDateTime.parse(apptDate) : null;
        return service.bookAppointment(patientId, doctorId, date);
    }

    @PutMapping("/{id}/status")
    public Appointment updateStatus(@PathVariable Integer id, @RequestParam String status) {
        return service.updateStatus(id, status);
    }
}
