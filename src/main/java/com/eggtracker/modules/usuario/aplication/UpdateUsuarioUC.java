package com.eggtracker.modules.usuario.aplication;

import com.eggtracker.modules.usuario.domain.entity.Usuario;
import com.eggtracker.modules.usuario.domain.service.UsuarioService;

public class UpdateUsuarioUC {
    public final UsuarioService usuarioService;

    public UpdateUsuarioUC(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void execute(Usuario usuario, int id) {
        usuarioService.updateUsuario(usuario, id);
    }
}
