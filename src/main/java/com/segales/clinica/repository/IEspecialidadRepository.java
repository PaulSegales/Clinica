package com.segales.clinica.repository;

import com.segales.clinica.model.Especialidades;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEspecialidadRepository extends JpaRepository<Especialidades, Integer> {
}
