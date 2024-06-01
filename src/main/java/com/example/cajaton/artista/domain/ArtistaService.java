package com.example.cajaton.artista.domain;

import com.example.cajaton.artista.infrastructure.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistaService {
    @Autowired
    private ArtistaRepository artistaRepository;
}
