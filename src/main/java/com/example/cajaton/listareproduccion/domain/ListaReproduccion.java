package com.example.cajaton.listareproduccion.domain;

import com.example.cajaton.usuario.domain.Usuario;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CollectionId;

import java.time.LocalDate;

@Entity
@Data
public class ListaReproduccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlaylist;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario idUser;

    private LocalDate fechaDeCreacion;
}
