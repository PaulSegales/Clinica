package com.segales.clinica.service.Impl;

import com.segales.clinica.model.Medico;

import java.util.List;

public interface IMedicoService {
    Medico create(Medico medico) throws Exception;
    Medico update(Medico medico) throws Exception;
    Medico findById(Integer id) throws Exception;
    List<Medico> findAll() throws Exception;
    Medico delete(Integer id) throws Exception;
    int count() throws Exception;
}
