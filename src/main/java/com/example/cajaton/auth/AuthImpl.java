package com.example.cajaton.auth;

import com.example.cajaton.usuario.domain.Role;
import com.example.cajaton.usuario.domain.UsuarioService;
import com.example.cajaton.usuario.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthImpl {

    @Autowired
    private UsuarioService userService;

    public boolean isOwnerResource(Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        Usuario user = userService.findByEmail(username);

        // No sirve lo de admin pero lo ponemos
        return user.getRole().equals(Role.ADMIN) || user.getIdUser().equals(id);
    }

    public String getCurrentEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }
}
