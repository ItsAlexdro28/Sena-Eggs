package com.eggtracker.modules.usuario.aplication;

import com.eggtracker.modules.usuario.domain.entity.Usuario;
import com.eggtracker.modules.usuario.domain.service.UsuarioService;

public class CreateUsuarioUC {
    private UsuarioService usuarioService;

    public CreateUsuarioUC(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void execute(Usuario usuario) {
        usuarioService.createUsuario(usuario);
    }
}
