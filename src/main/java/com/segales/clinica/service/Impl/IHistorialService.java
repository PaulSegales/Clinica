package com.segales.clinica.service.Impl;

import com.segales.clinica.model.Historial;

import java.util.List;

public interface IHistorialService {

    Historial create(Historial historial) throws Exception;
    Historial update(Historial historial) throws Exception;
    Historial findById(Integer id) throws Exception;
    List<Historial> findAll() throws Exception;
    Historial delete(Integer id) throws Exception;
}
