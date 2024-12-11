package com.eggtracker.modules.reportesproduccion.aplication;

import java.util.Optional;
import com.eggtracker.modules.reportesproduccion.domain.entity.ReporteProduccion;
import com.eggtracker.modules.reportesproduccion.domain.service.ReporteProduccionService;

public class ReadReporteProduccionUC {
    private ReporteProduccionService reporteProduccionService;

    public ReadReporteProduccionUC(ReporteProduccionService reporteProduccionService) {
        this.reporteProduccionService = reporteProduccionService;
    }

    public Optional<ReporteProduccion> execute(int reporteId) {
        return reporteProduccionService.readReporte(reporteId);
    }
}
