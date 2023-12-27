package com.todocodeacademy.turnos.persistence.DAO;

import com.todocodeacademy.turnos.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TurnoDAO extends JpaRepository<Turno, Long> {
}
