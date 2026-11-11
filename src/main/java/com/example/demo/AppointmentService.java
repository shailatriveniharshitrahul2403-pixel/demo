package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public List<Appointment> getAppointmentsByPatient(Integer patientId) {
        return appointmentRepository.findByPatientPatientId(patientId);
    }

    public Appointment bookAppointment(Integer patientId, Integer doctorId, LocalDateTime apptDate) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + patientId));
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + doctorId));

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setApptDate(apptDate != null ? apptDate : LocalDateTime.now().plusDays(1));
        appointment.setStatus("Scheduled");
        return appointmentRepository.save(appointment);
    }

    public Appointment updateStatus(Integer apptId, String status) {
        Appointment appt = appointmentRepository.findById(apptId)
                .orElseThrow(() -> new RuntimeException("Appointment not found with ID: " + apptId));
        appt.setStatus(status);
        return appointmentRepository.save(appt);
    }
}
