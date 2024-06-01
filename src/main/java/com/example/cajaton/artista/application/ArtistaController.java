package com.example.cajaton.artista.application;

import com.example.cajaton.artista.domain.Artista;
import com.example.cajaton.artista.domain.ArtistaService;
import com.example.cajaton.usuario.domain.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {
    @Autowired
    private ArtistaService artistaService;

    @GetMapping
    public List<Artista> getAllArtistas() {
        return artistaService.getAllArtistas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artista> getArtistaById(@PathVariable int id) {
        Optional<Artista> artista = artistaService.getArtistaById(id);
        if (artista.isPresent()) {
            return ResponseEntity.ok(artista.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Artista createArtista(@RequestBody Artista artista) {
        return artistaService.saveArtista(artista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artista> updateArtista(@PathVariable int id, @RequestBody Artista artistaDetails) {
        Optional<Artista> artista = artistaService.getArtistaById(id);
        if (artista.isPresent()) {
            Artista updatedArtista = artista.get();
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
