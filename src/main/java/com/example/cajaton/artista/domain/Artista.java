package com.example.cajaton.artista.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "artistas")
@Data
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idArtist;

    private String nombre;

}
