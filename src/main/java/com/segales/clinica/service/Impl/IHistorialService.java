package com.segales.clinica.service.Impl;

import com.segales.clinica.model.Historial;

import java.util.List;

public interface IHistorialService {

    public Historial create(Historial historial);
    public Historial update(Historial historial);
    public Historial findById(Integer id);
    public List<Historial> findAll();
    public void delete(Integer id);
}
