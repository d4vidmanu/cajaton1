package domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import java.time.LocalDateTime;

import java.util.Set;

@Data
@Entity
public class Salon {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String ubicacion;
    private int capacidad;
    private String descripcion;
    // Getters and Setters
}
