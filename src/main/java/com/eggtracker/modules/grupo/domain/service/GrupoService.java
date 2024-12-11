package com.eggtracker.modules.grupo.domain.service;

import java.util.Optional;

import com.eggtracker.modules.grupo.domain.entity.Grupo;

public interface GrupoService {
    void createGrupo(Grupo grupo);
    Optional<Grupo> readGrupo(int grupoId);
    void updateGrupo(Grupo grupo, int id);
    void deleteGrupo(int grupoId);
}
