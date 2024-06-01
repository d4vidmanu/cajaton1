package com.example.cajaton.auth.dto;

import lombok.Data;

@Data
public class AuthLoginRequest {
    public String username;
    public String password;
}
