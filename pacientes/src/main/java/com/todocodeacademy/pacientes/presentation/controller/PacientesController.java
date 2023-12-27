package com.todocodeacademy.pacientes.presentation.controller;

import com.todocodeacademy.pacientes.business.service.PacientesService;
import com.todocodeacademy.pacientes.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PacientesController {

    @Autowired
    private final PacientesService pacientesService;

    public PacientesController(PacientesService pacientesService) {
        this.pacientesService = pacientesService;
    }

    @GetMapping("/pacientes")
    public ResponseEntity<List<Patient>> getPacientes() {
        return ResponseEntity.ok(pacientesService.getPacientes());
    }

    @PostMapping("/pacientes")
    public ResponseEntity<Void> savePacientes(@RequestBody Patient paciente) {
        pacientesService.savePaciente(paciente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/pacientes")
    public ResponseEntity<Void> modifyPaciente(Patient paciente) {
        pacientesService.editPaciente(paciente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/pacientes/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Long id) {
        pacientesService.deletePaciente(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/pacientes/{id}")
    public ResponseEntity<Patient> findPacienteById(@PathVariable Long id) {
        return ResponseEntity.ok(pacientesService.findPaciente(id));
    }

    @GetMapping("/pacientes-dni/{dni}")
    public ResponseEntity<Patient> findByDni(@PathVariable String dni) {
        return ResponseEntity.ok(pacientesService.findPacienteByDni(dni));
    }

}
