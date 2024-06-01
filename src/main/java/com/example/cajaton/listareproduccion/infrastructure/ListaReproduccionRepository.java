package com.example.cajaton.listareproduccion.infrastructure;

import com.example.cajaton.listareproduccion.domain.ListaReproduccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaReproduccionRepository extends JpaRepository<ListaReproduccion, Integer> {
    public ListaReproduccion findByUsuarioId(Integer idUser);
}
