package com.eggtracker.modules.producciondiaria.aplication;

import com.eggtracker.modules.producciondiaria.domain.service.ProduccionDiariaService;

public class DeleteProduccionDiariaUC {
    private ProduccionDiariaService produccionDiariaService;

    public DeleteProduccionDiariaUC(ProduccionDiariaService produccionDiariaService) {
        this.produccionDiariaService = produccionDiariaService;
    }

    public void execute(int produccionId) {
        produccionDiariaService.deleteProduccionDiaria(produccionId);
    }
}
