package com.eggtracker.modules.grupo.aplication;

import com.eggtracker.modules.grupo.domain.entity.Grupo;
import com.eggtracker.modules.grupo.domain.service.GrupoService;

public class UpdateGrupoUC {
    public final GrupoService grupoService;

    public UpdateGrupoUC(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    public void execute(Grupo grupo, int id) {
        grupoService.updateGrupo(grupo, id);
    }
}
