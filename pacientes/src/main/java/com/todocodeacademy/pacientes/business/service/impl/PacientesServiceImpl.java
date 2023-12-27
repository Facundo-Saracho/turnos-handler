package com.todocodeacademy.pacientes.business.service.impl;

import com.todocodeacademy.pacientes.business.service.PacientesService;
import com.todocodeacademy.pacientes.model.Patient;
import com.todocodeacademy.pacientes.persistence.DAO.PatientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacientesServiceImpl implements PacientesService {

    @Autowired
    private final PatientDAO pacienteDAO;

    public PacientesServiceImpl(PatientDAO pacienteDAO) {
        this.pacienteDAO = pacienteDAO;
    }

    @Override
    public List<Patient> getPacientes() {
        return pacienteDAO.findAll();
    }

    @Override
    public void savePaciente(Patient paciente) {
        pacienteDAO.save(paciente);
    }

    @Override
    public void deletePaciente(Long id) {
        pacienteDAO.deleteById(id);
    }

    @Override
    public Patient findPaciente(Long id) {
        return pacienteDAO
                .findById(id)
                .orElse(null);
    }

    @Override
    public void editPaciente(Patient paciente) {
        this.savePaciente(paciente);
    }

    @Override
    public Patient findPacienteByDni(String dni) {
        return pacienteDAO.findByDni(dni);
    }
}
