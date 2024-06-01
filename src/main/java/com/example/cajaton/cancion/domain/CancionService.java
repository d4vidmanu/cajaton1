package com.example.cajaton.cancion.domain;

import com.example.cajaton.cancion.domain.Cancion;
import com.example.cajaton.cancion.infrastructure.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CancionService {

    private final CancionRepository cancionRepository;

    @Autowired
    public CancionService(CancionRepository cancionRepository) {
        this.cancionRepository = cancionRepository;
    }

    public List<Cancion> getAllCanciones() {
        return cancionRepository.findAll();
    }

    public Optional<Cancion> getCancionById(Integer id) {
        return cancionRepository.findById(id);
    }

    public Cancion createCancion(Cancion cancion) {
        return cancionRepository.save(cancion);
    }

    public Cancion updateCancion(Integer id, Cancion cancionDetails) {
        return cancionRepository.findById(id).map(cancion -> {
            cancion.setTitulo(cancionDetails.getTitulo());
            cancion.setDuracion(cancionDetails.getDuracion());
            cancion.setArtistaID(cancionDetails.getArtistaID());
            cancion.setIdAlbum(cancionDetails.getIdAlbum());
            cancion.setIdListaReproduccion(cancionDetails.getIdListaReproduccion());
            return cancionRepository.save(cancion);
        }).orElseGet(() -> {
            cancionDetails.setIdSong(id);
            return cancionRepository.save(cancionDetails);
        });
    }

    public void deleteCancion(Integer id) {
        cancionRepository.deleteById(id);
    }
}
