package com.segales.clinica.controller;

import com.segales.clinica.model.Horario;
import com.segales.clinica.service.HorarioService;
import com.segales.clinica.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/horario")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;
    @Autowired
    private MedicoService medicoService;
    private HashMap<String, Object> map;


    @GetMapping("/lista")
    public ResponseEntity<HashMap<String,Object>> findAll() {
        try {
            map = new HashMap<>();
            map.put("status", HttpStatus.OK.value());
            map.put("message", "Lista de horarios");
            map.put("data", horarioService.findAll());
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception e) {
            map = new HashMap<>();
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            map.put("message", "Error al obtener la lista de horarios");
            map.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }

    @PostMapping("/registrar_horario")
    public ResponseEntity<HashMap<String,Object>> create(@RequestBody Horario horario) {
        try {
            map = new HashMap<>();
            map.put("status", HttpStatus.CREATED.value());
            map.put("message", "Registro creado exitosamente");
            map.put("data", horarioService.create(horario));
            return new ResponseEntity<>(map, HttpStatus.CREATED);
        } catch (Exception e) {
            map = new HashMap<>();
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            map.put("message", "Error al crear registro ");
            map.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }

    @PutMapping("/actualizar_horario")
    public ResponseEntity<HashMap<String,Object>> update(@RequestBody Horario horario) {
        try {
            map = new HashMap<>();
            map.put("status", HttpStatus.OK.value());
            map.put("message", "Registro actualizado exitosamente");
            map.put("data", horarioService.update(horario));
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
    public ResponseEntity<HashMap<String,Object>> findById(@PathVariable("id") Integer idHorario) {
        try {
            map = new HashMap<>();
            map.put("status", HttpStatus.OK.value());
            map.put("message", "Registro encontrado");
            map.put("data", horarioService.findById(idHorario));
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
    public ResponseEntity<HashMap<String,Object>> delete(@PathVariable("id") Integer idHorario) {
        try {
            map = new HashMap<>();
            map.put("status", HttpStatus.OK.value());
            map.put("message", "Registro encontrado");
            //map.put("data", horarioService.delete(idHorario));
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
