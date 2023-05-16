package com.segales.clinica.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoRegistroDto {

    private Integer id;
    private String nombres;
    private String apellidos;
    private String email;
    private String dni;
    private String telefono;
    private int edad;
    private String password;
}
