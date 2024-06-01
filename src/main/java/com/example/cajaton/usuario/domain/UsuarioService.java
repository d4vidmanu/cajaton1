package com.example.cajaton.usuario.domain;

import com.example.cajaton.usuario.infrastructure.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Usuario> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }


}
