package com.feedfet.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "Los apellidos son obligatorios")
    private String apellidos;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email no es válido")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@fet\\.edu\\.co$", message = "El email debe ser del dominio fet.edu.co")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    private String password;
        
    @NotNull(message = "El rol es obligatorio")
    @Pattern(regexp = "^(ADMIN|ESTUDIANTE|CAFETERIA)$", message = "El rol debe ser ADMIN, ESTUDIANTE o CAFETERIA")
    @NotBlank(message = "El rol es obligatorio")
    private String rol;

    


}
