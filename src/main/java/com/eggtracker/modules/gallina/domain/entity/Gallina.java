package com.eggtracker.modules.gallina.domain.entity;

public class Gallina {
    private int gallinaId;
    private String nombre;
    private String fechaNacimiento;
    private int grupoId;
    private String estado;

    public Gallina(int gallinaId, String nombre, String fechaNacimiento, int grupoId, String estado) {
        this.gallinaId = gallinaId;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.grupoId = grupoId;
        this.estado = estado;
    }

    public Gallina() {
    }

    public int getGallinaId() {
        return gallinaId;
    }

    public void setGallinaId(int gallinaId) {
        this.gallinaId = gallinaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(int grupoId) {
        this.grupoId = grupoId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
