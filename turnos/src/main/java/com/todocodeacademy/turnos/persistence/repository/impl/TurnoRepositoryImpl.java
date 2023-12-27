package com.todocodeacademy.turnos.persistence.repository.impl;

import com.todocodeacademy.turnos.model.Paciente;
import com.todocodeacademy.turnos.model.Turno;
import com.todocodeacademy.turnos.persistence.DAO.TurnoDAO;
import com.todocodeacademy.turnos.persistence.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Repository
public class TurnoRepositoryImpl implements TurnoRepository {

    private final TurnoDAO turnoDAO;
    private final RestTemplate restTemplate;

    @Autowired
    public TurnoRepositoryImpl(TurnoDAO turnoDAO, RestTemplate restTemplate, RestTemplate restTemplate1) {
        this.turnoDAO = turnoDAO;
        this.restTemplate = restTemplate1;
    }


    @Override

    public List<Turno> getTurnos() {
        return turnoDAO.findAll();
    }

    @Override
    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente) {
        Paciente paciente = restTemplate.getForObject("http://localhost:9001/pacientes-dni/" + dniPaciente, Paciente.class);
        Turno turno = new Turno();
        turno.setFecha(fecha);
        turno.setTratamiento(tratamiento);
        turno.setNombreCompletoPaciente(paciente.getNombre() + " " + paciente.getApellido());
        turnoDAO.save(turno);
    }

    @Override
    public void deteleTurno(Long id) {
        turnoDAO.deleteById(id);
    }

    @Override
    public Turno findTurno(Long id) {
        return turnoDAO.findById(id).orElse(null);
    }

    @Override
    public void editTurno(Long id, Turno turno) {
        Turno nuevoTurno = findTurno(id);
        nuevoTurno.setFecha(turno.getFecha());
        nuevoTurno.setTratamiento(turno.getTratamiento());
        nuevoTurno.setNombreCompletoPaciente(turno.getNombreCompletoPaciente());
        turnoDAO.save(nuevoTurno);
    }
}
