package com.segales.clinica.service.Impl;

import com.segales.clinica.model.Especialidad;

import java.util.List;

public interface IEspecialidadService {

    public Especialidad create(Especialidad especialidad);
    public Especialidad update(Especialidad especialidad);
    public Especialidad findById(Integer id);
    public List<Especialidad> findAll();
    public void delete(Integer id);
}
