package com.eggtracker.modules.analisisalerta.aplication;

import com.eggtracker.modules.analisisalerta.domain.entity.AnalisisAlerta;
import com.eggtracker.modules.analisisalerta.domain.service.AnalisisAlertaService;

public class UpdateAnalisisAlertaUC {
    private AnalisisAlertaService analisisAlertaService;

    public UpdateAnalisisAlertaUC(AnalisisAlertaService analisisAlertaService) {
        this.analisisAlertaService = analisisAlertaService;
    }

    public void execute(AnalisisAlerta analisisAlerta, int analisisId) {
        analisisAlertaService.updateAnalisisAlerta(analisisAlerta, analisisId);
    }
}
