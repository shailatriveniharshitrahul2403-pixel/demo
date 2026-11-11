package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return repository.findAll();
    }

    @GetMapping("/search")
    public List<Doctor> searchBySpecialization(@RequestParam String specialization) {
        return repository.findBySpecializationContainingIgnoreCase(specialization);
    }

    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return repository.save(doctor);
    }

    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable Integer id) {
        repository.deleteById(id);
        return "Doctor deleted with ID: " + id;
    }
}
