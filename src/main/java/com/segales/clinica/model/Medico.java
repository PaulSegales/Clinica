package com.segales.clinica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombres;
    private String apellidos;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "medico_especialidad",
            joinColumns = @JoinColumn(name = "id_medico", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_especialidad", referencedColumnName = "id"))
    private List<Especialidades> especialidades;
    private String dni;
    private int edad;
    private String telefono;
}
