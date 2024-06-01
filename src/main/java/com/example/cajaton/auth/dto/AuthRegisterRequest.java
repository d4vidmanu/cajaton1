package com.example.cajaton.auth.dto;

import com.example.cajaton.usuario.domain.Role;
import lombok.Data;

@Data
public class AuthRegisterRequest {
    String name;
    String email;
    String password;
    String phone;
    private Role role; // Asegúrate de que el Role sea una clase o enum adecuada

}