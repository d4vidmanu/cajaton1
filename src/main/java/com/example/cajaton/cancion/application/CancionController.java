package com.example.cajaton.cancion.application;

import com.example.cajaton.cancion.domain.Cancion;
import com.example.cajaton.cancion.domain.CancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/canciones")
public class CancionController {

    private final CancionService cancionService;

    @Autowired
    public CancionController(CancionService cancionService) {
        this.cancionService = cancionService;
    }

    @GetMapping
    public List<Cancion> getAllCanciones() {
        return cancionService.getAllCanciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cancion> getCancionById(@PathVariable Integer id) {
        return cancionService.getCancionById(id)
                .map(cancion -> ResponseEntity.ok().body(cancion))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cancion createCancion(@RequestBody Cancion cancion) {
        return cancionService.createCancion(cancion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cancion> updateCancion(@PathVariable Integer id, @RequestBody Cancion cancionDetails) {
        return cancionService.getCancionById(id)
                .map(cancion -> ResponseEntity.ok(cancionService.updateCancion(id, cancionDetails)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCancion(@PathVariable Integer id) {
        return cancionService.getCancionById(id)
                .map(cancion -> {
                    cancionService.deleteCancion(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
