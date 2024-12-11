package com.eggtracker.modules.producciondiaria.domain.entity;

import java.sql.Date;

public class ProduccionDiaria {
    private int produccionId;
    private int gallinaId;
    private Date fecha;
    private int cantidad;

    public ProduccionDiaria(int produccionId, int gallinaId, Date fecha, int cantidad) {
        this.produccionId = produccionId;
        this.gallinaId = gallinaId;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public ProduccionDiaria() {}

    public int getProduccionId() {
        return produccionId;
    }

    public void setProduccionId(int produccionId) {
        this.produccionId = produccionId;
    }

    public int getGallinaId() {
        return gallinaId;
    }

    public void setGallinaId(int gallinaId) {
        this.gallinaId = gallinaId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
