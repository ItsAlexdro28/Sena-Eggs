package com.eggtracker.modules.usuario.domain.service;

import java.util.Optional;

import com.eggtracker.modules.usuario.domain.entity.Usuario;

public interface UsuarioService {
    public void createUsuario(Usuario usuario);
    public Optional<Usuario> readUsuario(int usuarioId);
    public void updateUsuario(Usuario usuario, int id);
    public void deleteUsuario(int usuarioId);
}
