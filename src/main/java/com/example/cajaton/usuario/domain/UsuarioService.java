package com.example.cajaton.usuario.domain;

import com.example.cajaton.usuario.dto.UsuarioDTO;
import com.example.cajaton.usuario.infrastructure.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    private UsuarioDTO convertToDto(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    public List<UsuarioDTO> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<UsuarioDTO> findById(Long id) {
        return usuarioRepository.findById(id)
                .map(this::convertToDto);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void delete(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            usuarioRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario No Encontrado");
        }
    }

    public Usuario updateUsuario(Long id, Usuario usuarioDetalles) {
        return usuarioRepository.findById(id).map(usuario -> {
            if (usuarioDetalles.getNombre() != null) {
                usuario.setNombre(usuarioDetalles.getNombre());
            }
            if (usuarioDetalles.getEmail() != null) {
                usuario.setEmail(usuarioDetalles.getEmail());
            }
            try {
                return usuarioRepository.save(usuario);
            } catch (Exception e) {
                throw new ResponseStatusException(BAD_REQUEST, "No puedes actualizar los datos, ya que son incorrectos");
            }
        }).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Usuario No Encontrado"));


    }
}
