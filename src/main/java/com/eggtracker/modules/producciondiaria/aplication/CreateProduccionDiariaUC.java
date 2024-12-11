package com.eggtracker.modules.producciondiaria.aplication;

import com.eggtracker.modules.producciondiaria.domain.entity.ProduccionDiaria;
import com.eggtracker.modules.producciondiaria.domain.service.ProduccionDiariaService;

public class CreateProduccionDiariaUC {
    private ProduccionDiariaService produccionDiariaService;

    public CreateProduccionDiariaUC(ProduccionDiariaService produccionDiariaService) {
        this.produccionDiariaService = produccionDiariaService;
    }

    public void execute(ProduccionDiaria produccionDiaria) {
        produccionDiariaService.createProduccionDiaria(produccionDiaria);
    }
}
