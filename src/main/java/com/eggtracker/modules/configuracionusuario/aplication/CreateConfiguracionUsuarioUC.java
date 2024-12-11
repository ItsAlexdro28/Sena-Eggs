package com.eggtracker.modules.configuracionusuario.aplication;

import com.eggtracker.modules.configuracionusuario.domain.entity.ConfiguracionUsuario;
import com.eggtracker.modules.configuracionusuario.domain.service.ConfiguracionUsuarioService;

public class CreateConfiguracionUsuarioUC {
    private ConfiguracionUsuarioService configuracionUsuarioService;

    public CreateConfiguracionUsuarioUC(ConfiguracionUsuarioService configuracionUsuarioService) {
        this.configuracionUsuarioService = configuracionUsuarioService;
    }

    public void execute(ConfiguracionUsuario configuracionUsuario) {
        configuracionUsuarioService.createConfiguracionUsuario(configuracionUsuario);
    }
}
