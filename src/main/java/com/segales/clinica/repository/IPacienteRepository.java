package com.segales.clinica.repository;

import com.segales.clinica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {
    Optional<Paciente> findByDni(String dni);
    List<Paciente> findAllByOrderByIdAsc();
}
