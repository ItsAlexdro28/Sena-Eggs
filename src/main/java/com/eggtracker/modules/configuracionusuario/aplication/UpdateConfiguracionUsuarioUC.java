package com.eggtracker.modules.configuracionusuario.aplication;

import com.eggtracker.modules.configuracionusuario.domain.entity.ConfiguracionUsuario;
import com.eggtracker.modules.configuracionusuario.domain.service.ConfiguracionUsuarioService;

public class UpdateConfiguracionUsuarioUC {
    public final ConfiguracionUsuarioService configuracionUsuarioService;

    public UpdateConfiguracionUsuarioUC(ConfiguracionUsuarioService configuracionUsuarioService) {
        this.configuracionUsuarioService = configuracionUsuarioService;
    }

    public void execute(ConfiguracionUsuario configuracionUsuario, int id) {
        configuracionUsuarioService.updateConfiguracionUsuario(configuracionUsuario, id);
    }
}
