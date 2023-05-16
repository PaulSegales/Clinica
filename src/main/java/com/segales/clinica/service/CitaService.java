package com.segales.clinica.service;

import com.segales.clinica.model.Cita;
import com.segales.clinica.repository.ICitaRepository;
import com.segales.clinica.service.Impl.ICitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService implements ICitaService {

    @Autowired
    private ICitaRepository citaRepository;

    @Override
    public Cita create(Cita cita) throws Exception{
        return citaRepository.save(cita);
    }

    @Override
    public Cita update(Cita citaActualizada) throws Exception {
        Optional<Cita> citaRegistrada = citaRepository.findById(citaActualizada.getId());
        if (citaRegistrada.isPresent())
            return citaRepository.save(citaActualizada);
        else
            throw new Exception("La cita con ID [" + citaActualizada.getId() + "] no existe en la base de datos.");
    }

    @Override
    public Cita findById(Integer id) throws Exception{
        Optional<Cita> citaRegistrada = citaRepository.findById(id);
        if (citaRegistrada.isPresent())
            return citaRegistrada.orElse(null);
        else
            throw new Exception("La cita con ID [" + id + "] no existe en la base de datos.");
    }

    @Override
    public List<Cita> findAll() throws Exception{
        List<Cita> lista = citaRepository.findAll();
        if (lista.isEmpty())
            throw new Exception("No se encontraron registros en la base de datos");
        else
            return lista;
    }

    @Override
    public Cita delete(Integer id) throws Exception {
        Optional<Cita> citaRegistrada = citaRepository.findById(id);
        if (citaRegistrada.isPresent()) {
            citaRegistrada.get().setEstado("false");
            return citaRepository.save(citaRegistrada.get());
        } else {
            throw new Exception("La cita con ID [" + id + "] no existe en la base de datos");
        }
    }
}
