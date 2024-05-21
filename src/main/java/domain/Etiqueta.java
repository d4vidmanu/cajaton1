package domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

import java.util.Set;

@Data
@Entity
public class Etiqueta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    // Getters and Setters
}
