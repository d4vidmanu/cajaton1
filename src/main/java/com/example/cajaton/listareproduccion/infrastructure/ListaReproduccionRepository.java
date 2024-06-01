package com.example.cajaton.listareproduccion.infrastructure;

import com.example.cajaton.listareproduccion.domain.ListaReproduccion;
import com.example.cajaton.usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaReproduccionRepository extends JpaRepository<ListaReproduccion, Integer> {
    ListaReproduccion findByIdUser(Usuario idUser);
}
