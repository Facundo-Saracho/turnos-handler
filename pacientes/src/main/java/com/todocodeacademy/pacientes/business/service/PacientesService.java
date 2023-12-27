package com.todocodeacademy.pacientes.business.service;

import com.todocodeacademy.pacientes.model.Patient;

import java.util.List;

public interface PacientesService {

    List<Patient> getPacientes();

    void savePaciente(Patient paciente);

    void deletePaciente(Long id);

    Patient findPaciente(Long id);

    void editPaciente(Patient paciente);

    Patient findPacienteByDni(String dni);

}
