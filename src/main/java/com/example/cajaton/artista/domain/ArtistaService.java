package com.example.cajaton.artista.domain;

import com.example.cajaton.artista.infrastructure.ArtistaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistaService {
    @Autowired
    private ArtistaRepository artistaRepository;

    @Autowired
    private ModelMapper mapper;

    public List<Artista> getAllArtistas() {
        return artistaRepository.findAll();
    }

    public Optional<Artista> getArtistaById(int id) {
        return artistaRepository.findById(id);
    }

    public Artista saveArtista(Artista artista) {
        return artistaRepository.save(artista);
    }

    public void deleteArtista(int id) {
        artistaRepository.deleteById(id);
    }
}
