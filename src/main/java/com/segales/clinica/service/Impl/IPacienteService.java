package com.segales.clinica.service.Impl;

import com.segales.clinica.model.Paciente;

import java.util.List;

public interface IPacienteService {

    public Paciente create(Paciente paciente);
    public Paciente update(Paciente paciente);
    public Paciente findById(Integer id);
    public List<Paciente> findAll();
    public void delete(Integer id);
}
