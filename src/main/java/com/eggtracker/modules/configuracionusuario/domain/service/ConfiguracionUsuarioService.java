package com.eggtracker.modules.configuracionusuario.domain.service;

import java.util.Optional;

import com.eggtracker.modules.configuracionusuario.domain.entity.ConfiguracionUsuario;

public interface ConfiguracionUsuarioService {
    void createConfiguracionUsuario(ConfiguracionUsuario configuracionUsuario);
    Optional<ConfiguracionUsuario> readConfiguracionUsuario(int configuracionId);
    void updateConfiguracionUsuario(ConfiguracionUsuario configuracionUsuario, int id);
    void deleteConfiguracionUsuario(int configuracionId);
}
