package com.eggtracker.modules.grupo.aplication;

import com.eggtracker.modules.grupo.domain.entity.Grupo;
import com.eggtracker.modules.grupo.domain.service.GrupoService;
import java.util.Optional;

public class ReadGrupoUC {
    private GrupoService grupoService;

    public ReadGrupoUC(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    public Optional<Grupo> execute(int grupoId) {
        return grupoService.readGrupo(grupoId);
    }
}
