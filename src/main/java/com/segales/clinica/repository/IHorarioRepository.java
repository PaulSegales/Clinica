package com.segales.clinica.repository;

import com.segales.clinica.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface IHorarioRepository extends JpaRepository<Horario, Integer> {

//    @Query("SELECT h FROM horario h WHERE h.fecha = :fecha AND h.hora = :hora AND h.medico.id = :idMedico")
//    Optional<Horario> findByDateTimeAndIdMedico(@Param("fecha") LocalDate fecha, @Param("hora") LocalTime hora, @Param("idMedico") Integer idMedico);



}
