package com.segales.clinica.controller;

import com.segales.clinica.model.Cita;
import com.segales.clinica.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("api/cita")
public class CitaController {

    @Autowired
    private CitaService citaService;
    private HashMap<String, Object> map;


    @GetMapping("/lista")
    public ResponseEntity<HashMap<String,Object>> findAll() {
        try {
            map = new HashMap<>();
            map.put("status", HttpStatus.OK.value());
            map.put("message", "Lista de citas");
            map.put("data", citaService.findAll());
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception e) {
            map = new HashMap<>();
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            map.put("message", "Error al obtener la lista de citas");
            map.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }

    @PostMapping("/registrar_cita")
    public ResponseEntity<HashMap<String,Object>> create(@RequestBody Cita cita) {
        try {
            map = new HashMap<>();
            map.put("status", HttpStatus.CREATED.value());
            map.put("message", "Registro creado exitosamente");
            map.put("data", citaService.create(cita));
            return new ResponseEntity<>(map, HttpStatus.CREATED);
        } catch (Exception e) {
            map = new HashMap<>();
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            map.put("message", "Error al crear registro ");
            map.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }

    @PutMapping("/actualizar_cita")
    public ResponseEntity<HashMap<String,Object>> update(@RequestBody Cita cita) {
        try {
            map = new HashMap<>();
            map.put("status", HttpStatus.OK.value());
            map.put("message", "Registro actualizado exitosamente");
            map.put("data", citaService.update(cita));
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
    public ResponseEntity<HashMap<String,Object>> findById(@PathVariable("id") Integer idCita) {
        try {
            map = new HashMap<>();
            map.put("status", HttpStatus.OK.value());
            map.put("message", "Registro encontrado");
            map.put("data", citaService.findById(idCita));
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
    public ResponseEntity<HashMap<String,Object>> delete(@PathVariable("id") Integer idCita) {
        try {
            map = new HashMap<>();
            map.put("status", HttpStatus.OK.value());
            map.put("message", "Registro encontrado");
            map.put("data", citaService.delete(idCita));
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
