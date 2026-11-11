package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public List<Patient> getAllPatients() {
        return repository.findAll();
    }

    public Patient getPatientById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + id));
    }

    public List<Patient> searchPatientsByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public Patient createPatient(Patient patient) {
        return repository.save(patient);
    }

    public Patient updatePatient(Integer id, Patient updated) {
        Patient existing = getPatientById(id);
        existing.setName(updated.getName());
        existing.setDob(updated.getDob());
        existing.setGender(updated.getGender());
        existing.setContact(updated.getContact());
        existing.setAddress(updated.getAddress());
        return repository.save(existing);
    }

    public void deletePatient(Integer id) {
        repository.deleteById(id);
    }
}
