package com.segales.clinica.service.Impl;

import com.segales.clinica.model.Paciente;

import java.util.List;

public interface IPacienteService {

    Paciente create(Paciente paciente) throws Exception;
    Paciente update(Paciente paciente) throws Exception;
    Paciente findById(Integer id) throws Exception;
    List<Paciente> findAll() throws Exception;
    Paciente delete(Integer id) throws Exception;
}
