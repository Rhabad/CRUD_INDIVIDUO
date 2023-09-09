package com.rhabad.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "individuo")
public class Individuo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Individuo")
    private Long idIndividuo;

    @NotEmpty //para la validacion
    private String nombre;
    @NotEmpty
    private String apellido;

    private int edad;

    @Email
    private String correo;
    @NotEmpty
    private String telefono;


}
