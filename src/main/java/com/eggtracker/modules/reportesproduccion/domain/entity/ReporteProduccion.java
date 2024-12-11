package com.eggtracker.modules.reportesproduccion.domain.entity;

public class ReporteProduccion {
    private int reporteId;
    private int produccionId;
    private int analisisId;

	public ReporteProduccion () {

	}

	public ReporteProduccion (int reporteId, int produccionId, int analisisId) {
		this.reporteId = reporteId;
		this.produccionId = produccionId;
		this.analisisId = analisisId;
	}

    public int getReporteId() {
        return reporteId;
    }

    public void setReporteId(int reporteId) {
        this.reporteId = reporteId;
    }

    public int getProduccionId() {
        return produccionId;
    }

    public void setProduccionId(int produccionId) {
        this.produccionId = produccionId;
    }

    public int getAnalisisId() {
        return analisisId;
    }

    public void setAnalisisId(int analisisId) {
        this.analisisId = analisisId;
    }
}
