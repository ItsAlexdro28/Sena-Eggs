package com.eggtracker.modules.reportesproduccion.aplication;

import com.eggtracker.modules.reportesproduccion.domain.entity.ReporteProduccion;
import com.eggtracker.modules.reportesproduccion.domain.service.ReporteProduccionService;

public class UpdateReporteProduccionUC {
    private ReporteProduccionService reporteProduccionService;

    public UpdateReporteProduccionUC(ReporteProduccionService reporteProduccionService) {
        this.reporteProduccionService = reporteProduccionService;
    }

    public void execute(ReporteProduccion reporte, int reporteId) {
        reporteProduccionService.updateReporte(reporte, reporteId);
    }
}
