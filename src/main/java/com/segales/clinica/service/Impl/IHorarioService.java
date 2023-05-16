package com.segales.clinica.service.Impl;

import com.segales.clinica.model.Horario;

import java.util.List;

public interface IHorarioService {

    Horario create(Horario horario) throws Exception;
    Horario update(Horario horario) throws Exception;
    Horario findById(Integer id) throws Exception;
    List<Horario> findAll() throws Exception;
    //List<Horario> findByMedicoId(Integer id) throws Exception;
    Horario delete(Integer id) throws Exception;
}
