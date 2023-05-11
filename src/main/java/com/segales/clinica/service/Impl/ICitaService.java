package com.segales.clinica.service.Impl;

import com.segales.clinica.model.Cita;

import java.util.List;

public interface ICitaService {

    public Cita create(Cita cita);
    public Cita update(Cita cita);
    public Cita findById(Integer id);
    public List<Cita> findAll();
    public void delete(Integer id);
}
