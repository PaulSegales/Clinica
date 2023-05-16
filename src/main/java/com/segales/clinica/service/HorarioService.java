package com.segales.clinica.service;

import com.segales.clinica.model.Horario;
import com.segales.clinica.repository.IHorarioRepository;
import com.segales.clinica.service.Impl.IHorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioService implements IHorarioService {

    @Autowired
    private IHorarioRepository horarioRepository;

    @Override
    public Horario create(Horario horario) throws Exception {
        Optional<Horario> horarioRegistrado = horarioRepository
                .findById(horario.getId());
        if (horarioRegistrado.isEmpty())
            return horarioRepository.save(horario);
        else
            throw new Exception("El horario ya ha sido registrado anteriormente");
    }

    @Override
    public Horario update(Horario horario) throws Exception {
        Optional<Horario> horarioRegistrado = horarioRepository
                .findById(horario.getId());
        if (horarioRegistrado.isPresent())
            return horarioRepository.save(horario);
        else
            throw new Exception("El horario no existe en la base de datos");
    }

    @Override
    public Horario findById(Integer id) throws Exception{
        Optional<Horario> horarioRegistrado = horarioRepository.findById(id);
        if (horarioRegistrado.isPresent())
            return horarioRegistrado.get();
        else
            throw new Exception("El horario no existe en la base de datos");
    }

    @Override
    public List<Horario> findAll() throws Exception {
        List<Horario> lista = horarioRepository.findAll();
        if (lista.isEmpty())
            throw new Exception("No se encontraron registros en la base de datos");
        else
            return lista;
    }

    @Override
    public Horario delete(Integer id) throws Exception{
        Optional<Horario> horarioRegistrado = horarioRepository.findById(id);
        if (horarioRegistrado.isPresent())
            return  null;
        else
            throw new Exception("El horario no existe en la base de datos");
    }

}
