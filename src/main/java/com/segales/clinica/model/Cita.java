package com.segales.clinica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cita")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;
    @OneToOne
    @JoinColumn(name = "id_horario")
    private Horario horario;
    private LocalDateTime fechaReservada;
    private String estado; //disponible, reservado, vencido
}
