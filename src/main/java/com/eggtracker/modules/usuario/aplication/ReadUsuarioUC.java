package com.eggtracker.modules.usuario.aplication;

import com.eggtracker.modules.usuario.domain.entity.Usuario;
import com.eggtracker.modules.usuario.domain.service.UsuarioService;
import java.util.Optional;

public class ReadUsuarioUC {
    private UsuarioService usuarioService;

    public ReadUsuarioUC(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public Optional<Usuario> execute(int usuarioId) {
        return usuarioService.readUsuario(usuarioId);
    }
}
