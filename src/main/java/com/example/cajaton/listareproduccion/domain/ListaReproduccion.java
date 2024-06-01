package com.example.cajaton.listareproduccion.domain;

import com.example.cajaton.cancion.domain.Cancion;
import com.example.cajaton.usuario.domain.Usuario;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CollectionId;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = ListaReproduccion.class)
public class ListaReproduccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlaylist;

    private String nombre;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

    private LocalDate fechaDeCreacion;

    @OneToMany
    private List<Cancion> canciones;
}
