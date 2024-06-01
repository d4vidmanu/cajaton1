package com.example.cajaton.usuario.domain;

import com.example.cajaton.cancion.domain.Cancion;
import com.example.cajaton.listareproduccion.domain.ListaReproduccion;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

    @Column(nullable = false)
    private String nombre;

    @Email
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDate fechaDeRegistro;

    @OneToMany
    private List<Cancion> cancion;

    @OneToMany
    private List<ListaReproduccion> listaReproduccion;
}
