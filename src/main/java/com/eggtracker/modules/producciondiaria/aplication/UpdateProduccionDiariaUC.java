package com.eggtracker.modules.producciondiaria.aplication;

import com.eggtracker.modules.producciondiaria.domain.entity.ProduccionDiaria;
import com.eggtracker.modules.producciondiaria.domain.service.ProduccionDiariaService;

public class UpdateProduccionDiariaUC {
    private final ProduccionDiariaService produccionDiariaService;

    public UpdateProduccionDiariaUC(ProduccionDiariaService produccionDiariaService) {
        this.produccionDiariaService = produccionDiariaService;
    }

    public void execute(ProduccionDiaria produccionDiaria, int produccionId) {
        produccionDiariaService.updateProduccionDiaria(produccionDiaria, produccionId);
    }
}
