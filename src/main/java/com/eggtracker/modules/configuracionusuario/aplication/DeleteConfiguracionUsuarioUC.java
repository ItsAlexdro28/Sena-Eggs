package com.eggtracker.modules.configuracionusuario.aplication;

import com.eggtracker.modules.configuracionusuario.domain.service.ConfiguracionUsuarioService;

public class DeleteConfiguracionUsuarioUC {
    private ConfiguracionUsuarioService configuracionUsuarioService;

    public DeleteConfiguracionUsuarioUC(ConfiguracionUsuarioService configuracionUsuarioService) {
        this.configuracionUsuarioService = configuracionUsuarioService;
    }

    public void execute(int configuracionId) {
        configuracionUsuarioService.deleteConfiguracionUsuario(configuracionId);
    }
}
