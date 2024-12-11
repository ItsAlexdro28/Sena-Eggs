package com.eggtracker.modules.analisisalerta.domain.entity;

public class AnalisisAlerta {
    private int analisisId;
    private int usuarioId;
    private String fecha;
    private String tipoAnalisis;
    private String descripcion;

    public AnalisisAlerta(int analisisId, int usuarioId, String fecha, String tipoAnalisis, String descripcion) {
        this.analisisId = analisisId;
        this.usuarioId = usuarioId;
        this.fecha = fecha;
        this.tipoAnalisis = tipoAnalisis;
        this.descripcion = descripcion;
    }

	public AnalisisAlerta () {}

    public int getAnalisisId() {
        return analisisId;
    }

    public void setAnalisisId(int analisisId) {
        this.analisisId = analisisId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoAnalisis() {
        return tipoAnalisis;
    }

    public void setTipoAnalisis(String tipoAnalisis) {
        this.tipoAnalisis = tipoAnalisis;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
