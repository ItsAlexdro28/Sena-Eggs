package com.eggtracker.modules.analisisalerta.aplication;

import com.eggtracker.modules.analisisalerta.domain.service.AnalisisAlertaService;

public class DeleteAnalisisAlertaUC {
    private AnalisisAlertaService analisisAlertaService;

    public DeleteAnalisisAlertaUC(AnalisisAlertaService analisisAlertaService) {
        this.analisisAlertaService = analisisAlertaService;
    }

    public void execute(int analisisId) {
        analisisAlertaService.deleteAnalisisAlerta(analisisId);
    }
}
