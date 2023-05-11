package com.segales.clinica.repository;

import com.segales.clinica.model.Historial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHistorialRepository extends JpaRepository<Historial, Integer> {
}
