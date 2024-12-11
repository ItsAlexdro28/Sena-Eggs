package com.eggtracker.modules.analisisalerta.aplication;

import com.eggtracker.modules.analisisalerta.domain.entity.AnalisisAlerta;
import com.eggtracker.modules.analisisalerta.domain.service.AnalisisAlertaService;

public class CreateAnalisisAlertaUC {
    private AnalisisAlertaService analisisAlertaService;

    public CreateAnalisisAlertaUC(AnalisisAlertaService analisisAlertaService) {
        this.analisisAlertaService = analisisAlertaService;
    }

    public void execute(AnalisisAlerta analisisAlerta) {
        analisisAlertaService.createAnalisisAlerta(analisisAlerta);
    }
}
