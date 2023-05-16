package com.segales.clinica.service;

import com.segales.clinica.model.Historial;
import com.segales.clinica.repository.IHistorialRepository;
import com.segales.clinica.service.Impl.IHistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialService implements IHistorialService {

    @Autowired
    private IHistorialRepository historialRepository;

    @Override
    public Historial create(Historial historial) {
        return historialRepository.save(historial);
    }

    @Override
    public Historial update(Historial historialActualizado) throws Exception{
        Optional<Historial> historialRegistrado = historialRepository.findById(historialActualizado.getId());
        if (historialRegistrado.isPresent())
            return historialRepository.save(historialActualizado);
        else
            throw new Exception("El historiak con ID [" + historialActualizado.getId() + "] no existe en la base de datos.");
    }

    @Override
    public Historial findById(Integer id) throws Exception{
        Optional<Historial> historialRegistrado = historialRepository.findById(id);
        if (historialRegistrado.isPresent())
            return historialRegistrado.get();
        else
            throw new Exception("El historial con ID [" + id + "] no existe en la base de datos");
    }

    @Override
    public List<Historial> findAll() throws Exception{
        List<Historial> lista = historialRepository.findAll();
        if (lista.isEmpty())
            throw new Exception("No se encontraron registros en la base de datos");
        else
            return lista;
    }

    @Override
    public Historial delete(Integer id) throws Exception {
        Optional<Historial> historialRegistrado = historialRepository.findById(id);
        if (historialRegistrado.isPresent()) {
            historialRegistrado.get().setEstado(false);
            return historialRepository.save(historialRegistrado.get());
        } else {
            throw new Exception("El historial con ID [" + id + "] no existe en la base de datos");
        }
    }
}
