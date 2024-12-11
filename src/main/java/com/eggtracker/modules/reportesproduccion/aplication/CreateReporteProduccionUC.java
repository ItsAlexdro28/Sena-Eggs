package com.eggtracker.modules.reportesproduccion.aplication;

import com.eggtracker.modules.reportesproduccion.domain.entity.ReporteProduccion;
import com.eggtracker.modules.reportesproduccion.domain.service.ReporteProduccionService;

public class CreateReporteProduccionUC {
    private ReporteProduccionService reporteProduccionService;

    public CreateReporteProduccionUC(ReporteProduccionService reporteProduccionService) {
        this.reporteProduccionService = reporteProduccionService;
    }

    public void execute(ReporteProduccion reporte) {
        reporteProduccionService.createReporte(reporte);
    }
}
