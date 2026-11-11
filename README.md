# Hospital & Patient Appointment Management REST API

A Spring Boot & MySQL backend application for managing hospital patients, doctors, and appointment scheduling.

## Tech Stack
- Java 17+ / Spring Boot 4
- Spring Data JPA & Hibernate ORM
- MySQL 8.0 & HikariCP

## API Endpoints
- **Patients:** GET /api/patients, POST /api/patients, GET /api/patients/search?name=, PUT /api/patients/{id}, DELETE /api/patients/{id}
- **Doctors:** GET /api/doctors, POST /api/doctors, GET /api/doctors/search?specialization=
- **Appointments:** GET /api/appointments, POST /api/appointments/book?patientId=1&doctorId=1, GET /api/appointments/patient/{id}, PUT /api/appointments/{id}/status
