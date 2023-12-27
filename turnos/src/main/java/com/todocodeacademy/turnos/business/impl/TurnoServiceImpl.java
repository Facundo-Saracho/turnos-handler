package com.todocodeacademy.turnos.business.impl;

import com.todocodeacademy.turnos.business.TurnoService;
import com.todocodeacademy.turnos.model.Turno;
import com.todocodeacademy.turnos.persistence.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TurnoServiceImpl implements TurnoService {

    @Autowired
    private final TurnoRepository turnoRepository;

    public TurnoServiceImpl(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    @Override
    public List<Turno> getTurnos() {
        return turnoRepository.getTurnos();
    }

    @Override
    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente) {
        turnoRepository.saveTurno(fecha, tratamiento, dniPaciente);
    }

    @Override
    public void deteleTurno(Long id) {
        turnoRepository.deteleTurno(id);
    }

    @Override
    public Turno findTurno(Long id) {
        return turnoRepository.findTurno(id);
    }

    @Override
    public void editTurno(Long id, Turno turno) {
        turnoRepository.editTurno(id, turno);
    }
}
