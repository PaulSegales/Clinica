package com.segales.clinica.service.Impl;

import com.segales.clinica.model.Medico;

import java.util.List;

public interface IMedicoService {
    public Medico create(Medico medico);
    public Medico update(Medico medico);
    public Medico findById(Integer id);
    public List<Medico> findAll();
    public void delete(Integer id);
}
