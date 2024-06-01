package com.example.cajaton.artista.domain;

import com.example.cajaton.artista.dto.ArtistaDTO;
import com.example.cajaton.artista.infrastructure.ArtistaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArtistaService {
    @Autowired
    private ArtistaRepository artistaRepository;

    @Autowired
    private ModelMapper mapper;

    public List<ArtistaDTO> getAllArtistas() {
        List<Artista> artistas = artistaRepository.findAll();
        return artistas.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<ArtistaDTO> getArtistaById(int id) {
        Optional<Artista> artista = artistaRepository.findById(id);
        return artista.map(this::convertToDto);
    }

    public ArtistaDTO saveArtista(ArtistaDTO artistaDto) {
        Artista artista = convertToEntity(artistaDto);
        Artista savedArtista = artistaRepository.save(artista);
        return convertToDto(savedArtista);
    }

    public void deleteArtista(int id) {
        artistaRepository.deleteById(id);
    }

    private ArtistaDTO convertToDto(Artista artista) {
        return mapper.map(artista, ArtistaDTO.class);
    }

    private Artista convertToEntity(ArtistaDTO artistaDto) {
        return mapper.map(artistaDto, Artista.class);
    }
}
