package com.segales.clinica.service.Impl;

import com.segales.clinica.model.Especialidad;

import java.util.List;

public interface IEspecialidadService {

    Especialidad create(Especialidad especialidad) throws Exception;
    Especialidad update(Especialidad especialidad) throws Exception;
    Especialidad findById(Integer id) throws Exception;
    List<Especialidad> findAll() throws Exception;
    Especialidad delete(Integer id) throws Exception;
}
