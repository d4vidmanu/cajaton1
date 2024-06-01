package com.example.cajaton.artista.domain;

import com.example.cajaton.cancion.domain.Cancion;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "artistas")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Artista.class)
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idArtist;

    private String nombre;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cancion> canciones;
    
}
