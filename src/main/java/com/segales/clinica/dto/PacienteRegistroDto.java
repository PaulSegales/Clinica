package com.segales.clinica.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteRegistroDto {

    private Integer id;
    private String nombres;
    private String apellidos;
    private String Email;
    private String dni;
    private String telefono;
    private LocalDate fechaNacimiento;
    private int edad;
    private Boolean estado;
    private String password;


}
