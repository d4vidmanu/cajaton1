package com.example.cajaton.cancion.infrastructure;

import com.example.cajaton.cancion.domain.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancionRepository extends JpaRepository<Cancion, Integer> {
}
