package com.segales.clinica.service;

import com.segales.clinica.model.Especialidad;
import com.segales.clinica.repository.IEspecialidadRepository;
import com.segales.clinica.service.Impl.IEspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadService implements IEspecialidadService {

    @Autowired
    private IEspecialidadRepository especialidadRepository;

    @Override
    public Especialidad create(Especialidad especialidad) throws Exception{
        Optional<Especialidad> especialidadRegistrada = especialidadRepository.findByNombre(especialidad.getNombre());
        if (especialidadRegistrada.isEmpty())
            return especialidadRepository.save(especialidad);
        else
            throw new Exception("La especialidad con el nombre [" + especialidad.getNombre() + "] ya ha sido registrado anteriormente.");
    }

    @Override
    public Especialidad update(Especialidad especialidadActualizada) throws Exception {
        Optional<Especialidad> especialidadRegistrada = especialidadRepository.findById(especialidadActualizada.getId());
        if (especialidadRegistrada.isPresent())
            return especialidadRepository.save(especialidadActualizada);
        else
            throw new Exception("La especialidad con ID [" + especialidadActualizada.getId() + "] no existe en la base de datos.");
    }

    @Override
    public Especialidad findById(Integer id) throws Exception {
        Optional<Especialidad> especialidadRegistrada = especialidadRepository.findById(id);
        if (especialidadRegistrada.isPresent())
            return especialidadRegistrada.get();
        else
            throw new Exception("La especialidad con ID [" + id + "] no existe en la base de datos.");
    }

    @Override
    public List<Especialidad> findAll() throws Exception{
        List<Especialidad> lista = especialidadRepository.findAll();
        if (lista.isEmpty())
            throw new Exception("No se encontraron registros en la base de datos");
        else
            return lista;
    }

    @Override
    public Especialidad delete(Integer id) throws Exception {
        Optional<Especialidad> especialidadRegistrada = especialidadRepository.findById(id);
        if (especialidadRegistrada.isPresent()) {
            especialidadRegistrada.get().setEstado(false);
            return especialidadRepository.save(especialidadRegistrada.get());
        } else {
            throw new Exception("La especialidad con ID [" + id + "] no existe en la base de datos");
        }
    }
}
