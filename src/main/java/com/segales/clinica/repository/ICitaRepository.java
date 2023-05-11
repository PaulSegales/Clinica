package com.segales.clinica.repository;

import com.segales.clinica.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICitaRepository extends JpaRepository<Cita, Integer> {
}
