package com.eggtracker.modules.configuracionusuario.domain.entity;

public class ConfiguracionUsuario {
    private int configuracionId;
    private int usuarioId;
    private boolean notificaciones;
    private String tema;
    private String idioma;

    public ConfiguracionUsuario(int configuracionId, int usuarioId, boolean notificaciones, String tema, String idioma) {
        this.configuracionId = configuracionId;
        this.usuarioId = usuarioId;
        this.notificaciones = notificaciones;
        this.tema = tema;
        this.idioma = idioma;
    }

    public ConfiguracionUsuario() {
    }

    public int getConfiguracionId() {
        return configuracionId;
    }

    public void setConfiguracionId(int configuracionId) {
        this.configuracionId = configuracionId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public boolean isNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(boolean notificaciones) {
        this.notificaciones = notificaciones;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
}
