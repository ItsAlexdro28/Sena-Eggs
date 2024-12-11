package com.eggtracker.modules.analisisalerta.aplication;

import com.eggtracker.modules.analisisalerta.domain.entity.AnalisisAlerta;
import com.eggtracker.modules.analisisalerta.domain.service.AnalisisAlertaService;
import java.util.Optional;

public class ReadAnalisisAlertaUC {
    private AnalisisAlertaService analisisAlertaService;

    public ReadAnalisisAlertaUC(AnalisisAlertaService analisisAlertaService) {
        this.analisisAlertaService = analisisAlertaService;
    }

    public Optional<AnalisisAlerta> execute(int analisisId) {
        return analisisAlertaService.readAnalisisAlerta(analisisId);
    }
}
