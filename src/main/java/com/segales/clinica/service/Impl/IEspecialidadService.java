package com.segales.clinica.service.Impl;

import com.segales.clinica.model.Especialidades;

import java.util.List;

public interface IEspecialidadService {

    public Especialidades create(Especialidades especialidades);
    public Especialidades update(Especialidades especialidades);
    public Especialidades findById(Integer id);
    public List<Especialidades> findAll();
    public void delete(Integer id);
}
