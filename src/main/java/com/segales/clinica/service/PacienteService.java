package com.segales.clinica.service;

import com.segales.clinica.model.Paciente;
import com.segales.clinica.repository.IPacienteRepository;
import com.segales.clinica.service.Impl.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Override
    public Paciente create(Paciente paciente) throws Exception {
        Optional<Paciente> pacienteRegistrado = pacienteRepository.findByDni(paciente.getDni());
        if (pacienteRegistrado.isEmpty())
            return pacienteRepository.save(paciente);
        else
            throw new Exception("El paciente con dni [" + paciente.getDni() + "] ya ha sido registrado anteriormente.");
    }

    @Override
    public Paciente update(Paciente pacienteActualizado) throws Exception{
        Optional<Paciente> pacienteRegistrado = pacienteRepository.findById(pacienteActualizado.getId());
        if (pacienteRegistrado.isPresent())
            return pacienteRepository.save(pacienteActualizado);
        else
            throw new Exception("El paciente con ID [" + pacienteActualizado.getId() + "] no existe en la base de datos.");
    }

    @Override
    public Paciente findById(Integer id) throws Exception {
        Optional<Paciente> pacienteRegistrado = pacienteRepository.findById(id);
        if (pacienteRegistrado.isPresent())
            return pacienteRegistrado.get();
        else
            throw new Exception("El paciente con ID [" + id + "] no existe en la base de datos");
    }

    @Override
    public List<Paciente> findAll() throws Exception {
        List<Paciente> lista = pacienteRepository.findAllByOrderByIdAsc()
                .stream()
                .filter(Paciente::getEstado)
                .collect(Collectors.toList());
        if (lista.isEmpty())
            throw new Exception("No se encontraron registros en la base de datos");
        else
            return lista;
    }

    @Override
    public Paciente delete(Integer id) throws Exception{
        Optional<Paciente> pacienteRegistrado = pacienteRepository.findById(id);
        if (pacienteRegistrado.isPresent()) {
            pacienteRegistrado.get().setEstado(false);
            return pacienteRepository.save(pacienteRegistrado.get());
        } else {
            throw new Exception("El paciente con ID [" + id + "] no existe en la base de datos");
        }
    }
}
