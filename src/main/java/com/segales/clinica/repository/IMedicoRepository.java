package com.segales.clinica.repository;

import com.segales.clinica.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IMedicoRepository extends JpaRepository<Medico, Integer> {
    Optional<Medico> findByDni(String dni);
    List<Medico> findAllByOrderByIdAsc();
    //@Query("SELECT u FROM Usuario u WHERE u.nombres = :nombres")
    //List<Usuario> buscarNombres(@Param("nombres") String nombres);
}
