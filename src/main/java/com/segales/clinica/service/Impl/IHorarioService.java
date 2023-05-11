package com.segales.clinica.service.Impl;

import com.segales.clinica.model.Horario;

import java.util.List;

public interface IHorarioService {

    public Horario create(Horario horario);
    public Horario update(Horario horario);
    public Horario findById(Integer id);
    public List<Horario> findAll();
    public void delete(Integer id);
}
