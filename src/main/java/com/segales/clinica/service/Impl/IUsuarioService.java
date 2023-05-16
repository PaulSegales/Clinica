package com.segales.clinica.service.Impl;

import com.segales.clinica.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUsuarioService {
    Usuario create(Usuario usuario) throws Exception;
    //Usuario update(Usuario usuario) throws Exception;
    Usuario findById(Integer id) throws Exception;
    List<Usuario> findAll() throws Exception;
    //Usuario delete(Integer id) throws Exception;
}
