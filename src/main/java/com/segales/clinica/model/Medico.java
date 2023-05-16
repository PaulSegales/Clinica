package com.segales.clinica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private String email;
    private String dni;
    private String telefono;
    private int edad;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "medico_especialidad",
            joinColumns = @JoinColumn(name = "id_medico", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_especialidad", referencedColumnName = "id"))
    private List<Especialidad> especialidad;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_medico", referencedColumnName = "id")
    private List<Horario> horarios;
    private boolean estado;
}
