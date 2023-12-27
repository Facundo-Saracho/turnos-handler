package com.todocodeacademy.turnos.business;

import com.todocodeacademy.turnos.model.Turno;

import java.time.LocalDate;
import java.util.List;

public interface TurnoService {

    List<Turno> getTurnos();

    void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente);

    void deteleTurno(Long id);

    Turno findTurno(Long id);

    void editTurno(Long id, Turno turno);
}
