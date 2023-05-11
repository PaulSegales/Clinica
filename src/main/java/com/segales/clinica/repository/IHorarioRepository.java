package com.segales.clinica.repository;

import com.segales.clinica.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHorarioRepository extends JpaRepository<Horario, Integer> {
}
