package com.eggtracker.modules.reportesproduccion.domain.service;

import java.util.Optional;
import com.eggtracker.modules.reportesproduccion.domain.entity.ReporteProduccion;

public interface ReporteProduccionService {
    void createReporte(ReporteProduccion reporte);
    Optional<ReporteProduccion> readReporte(int reporteId);
    void updateReporte(ReporteProduccion reporte, int reporteId);
    void deleteReporte(int reporteId);
}
