package com.example.cajaton.album.domain;

import com.example.cajaton.cancion.domain.Cancion;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAlbum;

    private String nombre;

    private LocalDate fechaDeLanzamiento;

    @OneToMany
    private List<Cancion> canciones;
}
