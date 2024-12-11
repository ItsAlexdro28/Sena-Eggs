package com.eggtracker.modules.reportesproduccion.aplication;

import com.eggtracker.modules.reportesproduccion.domain.service.ReporteProduccionService;

public class DeleteReporteProduccionUC {
    private ReporteProduccionService reporteProduccionService;

    public DeleteReporteProduccionUC(ReporteProduccionService reporteProduccionService) {
        this.reporteProduccionService = reporteProduccionService;
    }

    public void execute(int reporteId) {
        reporteProduccionService.deleteReporte(reporteId);
    }
}
