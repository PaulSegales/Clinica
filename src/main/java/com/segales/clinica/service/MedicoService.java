package com.segales.clinica.service;

import com.segales.clinica.model.Medico;
import com.segales.clinica.repository.IMedicoRepository;
import com.segales.clinica.service.Impl.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MedicoService implements IMedicoService {

    @Autowired
    private IMedicoRepository medicoRepository;

    @Override
    public Medico create(Medico medico) throws Exception {
        Optional<Medico> medicoRegistrado = medicoRepository.findByDni(medico.getDni());
        if (medicoRegistrado.isEmpty())
            return medicoRepository.save(medico);
        else
            throw new Exception("El médico con dni [" + medico.getDni() + "] ya ha sido registrado anteriormente.");
    }

    @Override
    public Medico update(Medico medicoActualizado) throws Exception {
        Optional<Medico> medicoRegistrado = medicoRepository.findById(medicoActualizado.getId());
        if (medicoRegistrado.isPresent())
            return medicoRepository.save(medicoActualizado);
        else
            throw new Exception("El médico con ID [" + medicoActualizado.getId() + "] no existe en la base de datos.");
    }

    @Override
    public Medico findById(Integer id) throws Exception{
        Optional<Medico> medicoRegistrado = medicoRepository.findById(id);
        if (medicoRegistrado.isPresent())
            return medicoRegistrado.get();
        else
            throw new Exception("El paciente con ID [" + id + "] no existe en la base de datos");
    }

    @Override
    public List<Medico> findAll() throws Exception{
        List<Medico> lista = medicoRepository.findAllByOrderByIdAsc();
        if (lista.isEmpty())
            throw new Exception("No se encontraron registros en la base de datos");
        else
            return lista;
    }

    @Override
    public Medico delete(Integer id) throws Exception{
        Optional<Medico> medicoRegistrado = medicoRepository.findById(id);
        if (medicoRegistrado.isPresent()) {
            medicoRegistrado.get().setEstado(false);
            return medicoRepository.save(medicoRegistrado.get());
        } else {
            throw new Exception("El médico con ID [" + id + "] no existe en la base de datos");
        }
    }

    @Override
    public int count() throws Exception {
        return (int) medicoRepository.count();
    }
}
