package com.example.cajaton.usuario.domain;

import com.example.cajaton.cancion.domain.Cancion;
import com.example.cajaton.listareproduccion.domain.ListaReproduccion;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idUser", scope = Usuario.class)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;  // Asegúrate de usar el enum correcto

    @Column(nullable = false)
    private String nombre;

    private String contrasena;

    @Email
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDate fechaDeRegistro;

    @OneToMany(mappedBy = "usuario")
    private List<Cancion> canciones;

    @OneToMany(mappedBy = "usuario")
    private List<ListaReproduccion> listaReproduccion;
}
