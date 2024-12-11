package com.eggtracker.modules.configuracionusuario.aplication;

import com.eggtracker.modules.configuracionusuario.domain.entity.ConfiguracionUsuario;
import com.eggtracker.modules.configuracionusuario.domain.service.ConfiguracionUsuarioService;

import java.util.Optional;

public class ReadConfiguracionUsuarioUC {
    private ConfiguracionUsuarioService configuracionUsuarioService;

    public ReadConfiguracionUsuarioUC(ConfiguracionUsuarioService configuracionUsuarioService) {
        this.configuracionUsuarioService = configuracionUsuarioService;
    }

    public Optional<ConfiguracionUsuario> execute(int configuracionId) {
        return configuracionUsuarioService.readConfiguracionUsuario(configuracionId);
    }
}
