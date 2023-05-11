package com.segales.clinica.repository;

import com.segales.clinica.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicoRepository extends JpaRepository<Medico, Integer> {
}
