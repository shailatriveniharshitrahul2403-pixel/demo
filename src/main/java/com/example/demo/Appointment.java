package com.example.demo;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appt_id")
    private Integer apptId;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Column(name = "appt_date")
    private LocalDateTime apptDate;

    @Column(name = "status")
    private String status;

    public Integer getApptId() { return apptId; }
    public void setApptId(Integer apptId) { this.apptId = apptId; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    public LocalDateTime getApptDate() { return apptDate; }
    public void setApptDate(LocalDateTime apptDate) { this.apptDate = apptDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
