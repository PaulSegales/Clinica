package com.segales.clinica.service;

import com.segales.clinica.model.Paciente;
import com.segales.clinica.model.Usuario;
import com.segales.clinica.repository.IUsuarioRepository;
import com.segales.clinica.service.Impl.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public Usuario create(Usuario usuario) throws Exception {
        Optional<Usuario> usuarioRegistrado = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioRegistrado.isEmpty())
            return usuarioRepository.save(usuario);
        else
            throw new Exception("El usuario con id [" + usuario.getId() + "] ya ha sido registrado anteriormente.");
    }

    @Override
    public Usuario findById(Integer id) throws Exception {
        Optional<Usuario> usuarioRegistrado = usuarioRepository.findById(id);
        if (usuarioRegistrado.isPresent())
            return usuarioRegistrado.get();
        else
            throw new Exception("El usuario con ID [" + id + "] no existe en la base de datos");
    }

    @Override
    public List<Usuario> findAll() throws Exception {
        List<Usuario> lista = usuarioRepository.findAllByOrderByIdAsc();
        if (lista.isEmpty())
            throw new Exception("No se encontraron registros en la base de datos");
        else
            return lista;
    }
}
