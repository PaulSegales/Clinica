package com.segales.clinica.controller;

import com.segales.clinica.dto.PacienteRegistroDto;
import com.segales.clinica.model.Paciente;
import com.segales.clinica.model.Usuario;
import com.segales.clinica.service.PacienteService;
import com.segales.clinica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("api/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private UsuarioService usuarioService;
    private HashMap<String, Object> map;


    @GetMapping("/lista")
    public ResponseEntity<HashMap<String,Object>> findAll() {
        try {
            map = new HashMap<>();
            map.put("status", HttpStatus.OK.value());
            map.put("message", "Lista de pacientes");
            map.put("data", pacienteService.findAll());
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception e) {
            map = new HashMap<>();
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            map.put("message", "Error al obtener la lista de pacientes");
            map.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }

    @PostMapping("/registrar_paciente")
    public ResponseEntity<HashMap<String,Object>> create(@RequestBody PacienteRegistroDto pacientedto) {

        try {
            Paciente paciente = new Paciente();
            paciente.setNombres(pacientedto.getNombres());
            paciente.setApellidos(pacientedto.getApellidos());
            paciente.setEmail(pacientedto.getEmail());
            paciente.setDni(pacientedto.getDni());
            paciente.setTelefono(pacientedto.getTelefono());
            paciente.setFechaNacimiento(pacientedto.getFechaNacimiento());
            paciente.setEdad(pacientedto.getEdad());
            paciente.setEstado(true);

            map = new HashMap<>();
            map.put("status", HttpStatus.CREATED.value());
            map.put("message", "Registro creado exitosamente");
            map.put("data", pacienteService.create(paciente));

            Usuario usuario = new Usuario();
            usuario.setEmail(pacientedto.getEmail());
            usuario.setPassword(pacientedto.getPassword());
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

    @PutMapping("/actualizar_paciente")
    public ResponseEntity<HashMap<String,Object>> update(@RequestBody Paciente paciente) {
        try {
            map = new HashMap<>();
            map.put("status", HttpStatus.OK.value());
            map.put("message", "Registro actualizado exitosamente");
            map.put("data", pacienteService.update(paciente));
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
    public ResponseEntity<HashMap<String,Object>> findById(@PathVariable("id") Integer idPaciente) {
        try {
            map = new HashMap<>();
            map.put("status", HttpStatus.OK.value());
            map.put("message", "Registro encontrado");
            map.put("data", pacienteService.findById(idPaciente));
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
    public ResponseEntity<HashMap<String,Object>> delete(@PathVariable("id") Integer idPaciente) {
        try {
            map = new HashMap<>();
            map.put("status", HttpStatus.OK.value());
            map.put("message", "Registro encontrado");
            map.put("data", pacienteService.delete(idPaciente));
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
