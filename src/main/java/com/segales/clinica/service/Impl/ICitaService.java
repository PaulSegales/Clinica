package com.segales.clinica.service.Impl;

import com.segales.clinica.model.Cita;

import java.util.List;

public interface ICitaService {

    Cita create(Cita cita) throws Exception;
    Cita update(Cita cita) throws Exception;
    Cita findById(Integer id) throws Exception;
    List<Cita> findAll() throws Exception;
    Cita delete(Integer id) throws Exception;
}
