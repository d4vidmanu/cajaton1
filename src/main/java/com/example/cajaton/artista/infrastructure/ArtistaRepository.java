package com.example.cajaton.artista.infrastructure;

import com.example.cajaton.artista.domain.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistaRepository extends JpaRepository <Artista, Integer>{
}
