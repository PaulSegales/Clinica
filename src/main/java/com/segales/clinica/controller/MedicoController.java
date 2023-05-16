package com.segales.clinica.controller;

import com.segales.clinica.dto.MedicoRegistroDto;
import com.segales.clinica.model.Medico;
import com.segales.clinica.model.Usuario;
import com.segales.clinica.service.MedicoService;
import com.segales.clinica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("api/medico")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;
    @Autowired
    private UsuarioService usuarioService;
    private HashMap<String, Object> map;


    @GetMapping("/lista")
    public ResponseEntity<HashMap<String,Object>> findAll() {
        try {
            map = new HashMap<>();
            map.put("status", HttpStatus.OK.value());
            map.put("message", "Lista de medicos");
            map.put("data", medicoService.findAll());
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception e) {
            map = new HashMap<>();
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            map.put("message", "Error al obtener la lista de médicos");
            map.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }

    @PostMapping("/registrar_medico")
    public ResponseEntity<HashMap<String,Object>> create(@RequestBody MedicoRegistroDto medicoDto) {
        try {
            Medico medico = new Medico();
            medico.setNombres(medicoDto.getNombres());
            medico.setApellidos(medicoDto.getApellidos());
            medico.setEmail(medicoDto.getEmail());
            medico.setDni(medicoDto.getDni());
            medico.setTelefono(medicoDto.getTelefono());
            medico.setEdad(medicoDto.getEdad());
            medico.setEstado(true);

            map = new HashMap<>();
            map.put("status", HttpStatus.CREATED.value());
            map.put("message", "Registro creado exitosamente");
            map.put("data", medicoService.create(medico));

            Usuario usuario = new Usuario();
            usuario.setEmail(medicoDto.getEmail());
            usuario.setPassword(medicoDto.getPassword());
            usuarioService.create(usuario);

            return new ResponseEntity<>(map, HttpStatus.CREATED);
        } catch (Exception e) {
            map = new HashMap<>();
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            map.put("message", "Error al crear registro ");
            map.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }

    @PutMapping("/actualizar_medico")
    public ResponseEntity<HashMap<String,Object>> update(@RequestBody Medico medico) {
        try {
            map = new HashMap<>();
            map.put("status", HttpStatus.OK.value());
            map.put("message", "Registro actualizado exitosamente");
            map.put("data", medicoService.update(medico));
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception e) {
            map = new HashMap<>();
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            map.put("message", "Error al actualizar registro");
            map.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<HashMap<String,Object>> findById(@PathVariable("id") Integer idMedico) {
        try {
            map = new HashMap<>();
            map.put("status", HttpStatus.OK.value());
            map.put("message", "Registro encontrado");
            map.put("data", medicoService.findById(idMedico));
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception e) {
            map = new HashMap<>();
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            map.put("message", "Error al buscar el registro");
            map.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HashMap<String,Object>> delete(@PathVariable("id") Integer idMedico) {
        try {
            map = new HashMap<>();
            map.put("status", HttpStatus.OK.value());
            map.put("message", "Registro encontrado");
            map.put("data", medicoService.delete(idMedico));
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception e) {
            map = new HashMap<>();
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            map.put("message", "Error al buscar el registro");
            map.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }
}
