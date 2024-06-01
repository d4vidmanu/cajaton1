package com.example.cajaton.auth.dto;

import lombok.Data;

@Data
public class AuthJwtResponse {
    public String token;
    public Integer id;
}
