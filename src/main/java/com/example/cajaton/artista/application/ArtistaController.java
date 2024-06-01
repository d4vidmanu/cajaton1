package com.example.cajaton.artista.application;

import com.example.cajaton.artista.domain.Artista;
import com.example.cajaton.artista.domain.ArtistaService;
import com.example.cajaton.artista.dto.ArtistaDTO;
import com.example.cajaton.usuario.domain.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/artistas")
public class ArtistaController {

    @Autowired
    private ArtistaService artistaService;

    @GetMapping
    public List<ArtistaDTO> getAllArtistas() {
        return artistaService.getAllArtistas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtistaDTO> getArtistaById(@PathVariable int id) {
        Optional<ArtistaDTO> artista = artistaService.getArtistaById(id);
        if (artista.isPresent()) {
            return ResponseEntity.ok(artista.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ArtistaDTO createArtista(@RequestBody ArtistaDTO artistaDto) {
        return artistaService.saveArtista(artistaDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArtistaDTO> updateArtista(@PathVariable int id, @RequestBody ArtistaDTO artistaDetails) {
        Optional<ArtistaDTO> artista = artistaService.getArtistaById(id);
        if (artista.isPresent()) {
            ArtistaDTO updatedArtista = artista.get();
            updatedArtista.setNombre(artistaDetails.getNombre());
            artistaService.saveArtista(updatedArtista);
            return ResponseEntity.ok(updatedArtista);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtista(@PathVariable int id) {
        if (artistaService.getArtistaById(id).isPresent()) {
            artistaService.deleteArtista(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}