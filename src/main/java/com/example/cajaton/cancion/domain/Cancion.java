package com.example.cajaton.cancion.domain;

import com.example.cajaton.album.domain.Album;
import com.example.cajaton.artista.domain.Artista;
import com.example.cajaton.listareproduccion.domain.ListaReproduccion;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "canciones")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Cancion.class)
public class Cancion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSong;

    private String titulo;

    private Integer duracion;

    @ManyToOne
    @JoinColumn(name = "artistaID")
    private Artista artistaID;

    @ManyToOne
    @JoinColumn(name = "album")
    private Album idAlbum;

    @ManyToOne
    @JoinColumn(name = "ListaDeReproduccion")
    private ListaReproduccion idListaReproduccion;
}
