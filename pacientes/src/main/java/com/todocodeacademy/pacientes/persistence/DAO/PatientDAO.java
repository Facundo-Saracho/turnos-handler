package com.todocodeacademy.pacientes.persistence.DAO;

import com.todocodeacademy.pacientes.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientDAO extends JpaRepository<Patient, Long> {

    @Query("SELECT p FROM Patient p WHERE p.dni=:dni")
    Patient findByDni(String dni);
}
