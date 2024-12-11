package com.eggtracker.modules.grupo.aplication;

import com.eggtracker.modules.grupo.domain.entity.Grupo;
import com.eggtracker.modules.grupo.domain.service.GrupoService;

public class CreateGrupoUC {
    private GrupoService grupoService;

    public CreateGrupoUC(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    public void execute(Grupo grupo) {
        grupoService.createGrupo(grupo);
    }
}
