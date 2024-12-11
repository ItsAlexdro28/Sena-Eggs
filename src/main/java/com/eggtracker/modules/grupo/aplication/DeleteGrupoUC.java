package com.eggtracker.modules.grupo.aplication;

import com.eggtracker.modules.grupo.domain.service.GrupoService;

public class DeleteGrupoUC {
    private GrupoService grupoService;

    public DeleteGrupoUC(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    public void execute(int grupoId) {
        grupoService.deleteGrupo(grupoId);
    }
}
