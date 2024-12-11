package com.eggtracker.modules.usuario.aplication;

import com.eggtracker.modules.usuario.domain.service.UsuarioService;

public class DeleteUsuarioUC {
    private UsuarioService usuarioService;

    public DeleteUsuarioUC(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void execute(int usuarioId) {
        usuarioService.deleteUsuario(usuarioId);
    }
}
