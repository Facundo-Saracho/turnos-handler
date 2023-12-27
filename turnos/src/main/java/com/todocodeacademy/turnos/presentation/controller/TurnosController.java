package com.todocodeacademy.turnos.presentation.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.todocodeacademy.turnos.business.TurnoService;
import com.todocodeacademy.turnos.model.Turno;
import com.todocodeacademy.turnos.presentation.DTOs.TurnoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnosController {

    @Autowired
    private final TurnoService turnoService;

    public TurnosController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Turno>> getTurnos() {
        return ResponseEntity.ok(turnoService.getTurnos());
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createTurno
            (@RequestBody TurnoDTO turnoDTO){
        turnoService.saveTurno(turnoDTO.getFecha(), turnoDTO.getTratamiento(), turnoDTO.getDniPaciente());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTurn(@PathVariable Long id) {
        turnoService.deteleTurno(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/modify/{id}")
    public ResponseEntity<Void> modifyTurno(
            @PathVariable Long id,
            @RequestBody Turno turno) {
        turnoService.editTurno(id, turno);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> findTurno(@PathVariable Long id) {
        return ResponseEntity.ok(turnoService.findTurno(id));
    }

}
