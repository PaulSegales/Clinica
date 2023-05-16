package com.segales.clinica.controller;

import com.segales.clinica.model.Especialidad;
import com.segales.clinica.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("api/especialidad")
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;
    private HashMap<String, Object> map;

    @GetMapping("/lista")
    public ResponseEntity<HashMap<String,Object>> findAll() {
        try {
            map = new HashMap<>();
            map.put("status", HttpStatus.OK.value());
            map.put("message", "Lista de especialidades");
            map.put("data", especialidadService.findAll());
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception e) {
            map = new HashMap<>();
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            map.put("message", "Error al obtener la lista de especialidades");
            map.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }

    @PostMapping("/registrar_especialidad")
    public ResponseEntity<HashMap<String,Object>> create(@RequestBody Especialidad especialidad) {
        try {
            map = new HashMap<>();
            map.put("status", HttpStatus.CREATED.value());
            map.put("message", "Registro creado exitosamente");
            map.put("data", especialidadService.create(especialidad));
            return new ResponseEntity<>(map, HttpStatus.CREATED);
        } catch (Exception e) {
            map = new HashMap<>();
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            map.put("message", "Error al crear registro ");
            map.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }

    @PutMapping("/actualizar_especialidad")
    public ResponseEntity<HashMap<String,Object>> update(@RequestBody Especialidad especialidad) {
        try {
            map = new HashMap<>();
            map.put("status", HttpStatus.OK.value());
            map.put("message", "Registro actualizado exitosamente");
            map.put("data", especialidadService.update(especialidad));
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
    public ResponseEntity<HashMap<String,Object>> findById(@PathVariable("id") Integer idEspecialidad) {
        try {
            map = new HashMap<>();
            map.put("status", HttpStatus.OK.value());
            map.put("message", "Registro encontrado");
            map.put("data", especialidadService.findById(idEspecialidad));
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
    public ResponseEntity<HashMap<String,Object>> delete(@PathVariable("id") Integer idEspecialidad) {
        try {
            map = new HashMap<>();
            map.put("status", HttpStatus.OK.value());
            map.put("message", "Registro encontrado");
            map.put("data", especialidadService.delete(idEspecialidad));
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
