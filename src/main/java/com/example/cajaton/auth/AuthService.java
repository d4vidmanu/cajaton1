package com.example.cajaton.auth;

import com.example.cajaton.auth.dto.AuthJwtResponse;
import com.example.cajaton.auth.dto.AuthLoginRequest;
import com.example.cajaton.auth.dto.AuthRegisterRequest;
import com.example.cajaton.config.JwtService;
import com.example.cajaton.usuario.domain.Usuario;
import com.example.cajaton.usuario.infrastructure.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class AuthService {

    final UsuarioRepository usuarioRepository;
    final JwtService jwtService;
    final PasswordEncoder passwordEncoder;
    final ModelMapper modelMapper;

    @Autowired
    public AuthService(UsuarioRepository usuarioRepository, JwtService jwtService, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    public AuthJwtResponse login(AuthLoginRequest req) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(req.getUsername());

        if (usuario.isEmpty()) throw new UsernameNotFoundException("Email is not registered");

        if (!passwordEncoder.matches(req.getPassword(), usuario.get().getContrasena()))
            throw new IllegalArgumentException("Password is incorrect");

        CustomUserDetails userDetails = new CustomUserDetails(usuario.get());

        AuthJwtResponse response = new AuthJwtResponse();
        response.setToken(jwtService.generateToken(userDetails));
        response.setId(usuario.get().getIdUser());
        return response;
    }

    public AuthJwtResponse register(AuthRegisterRequest req){
        Optional<Usuario> usuario = usuarioRepository.findByEmail(req.getEmail());
        if (usuario.isPresent()) throw new IllegalArgumentException("Email is already registered");

        Usuario newUsuario = new Usuario();
        newUsuario.setNombre(req.getName());
        newUsuario.setEmail(req.getEmail());
        newUsuario.setEmail(req.getEmail());
        newUsuario.setContrasena(passwordEncoder.encode(req.getPassword()));
        newUsuario.setFechaDeRegistro(LocalDate.now());
        newUsuario.setRole(req.getRole());

        usuarioRepository.save(newUsuario);

        CustomUserDetails userDetails = new CustomUserDetails(newUsuario);

        AuthJwtResponse response = new AuthJwtResponse();
        response.setToken(jwtService.generateToken(userDetails));
        response.setId(newUsuario.getIdUser());
        return response;
    }
}
