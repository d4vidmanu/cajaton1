package com.example.cajaton.listareproduccion.domain;

import com.example.cajaton.usuario.domain.Usuario;
import jakarta.persistence.*;

@Entity
public class ListaReproduccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlaylist;

    private String nombre;

    @ManyToOne
    private Usuario idUser;
}
