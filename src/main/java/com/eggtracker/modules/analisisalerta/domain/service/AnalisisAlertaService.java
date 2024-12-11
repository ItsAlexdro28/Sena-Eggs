package com.eggtracker.modules.analisisalerta.domain.service;

import java.util.Optional;

import com.eggtracker.modules.analisisalerta.domain.entity.AnalisisAlerta;

public interface AnalisisAlertaService {
    void createAnalisisAlerta(AnalisisAlerta analisisAlerta);
    Optional<AnalisisAlerta> readAnalisisAlerta(int analisisId);
    void updateAnalisisAlerta(AnalisisAlerta analisisAlerta, int analisisId);
    void deleteAnalisisAlerta(int analisisId);
}
