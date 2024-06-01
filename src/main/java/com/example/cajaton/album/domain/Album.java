package com.example.cajaton.album.domain;

import com.example.cajaton.cancion.domain.Cancion;
import com.example.cajaton.usuario.domain.Usuario;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Album.class)
public class Album extends Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAlbum;

    private String nombre;

    private LocalDate fechaDeLanzamiento;

    @OneToMany
    private List<Cancion> canciones;
}
