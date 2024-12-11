package com.eggtracker.modules.producciondiaria.domain.service;

import com.eggtracker.modules.producciondiaria.domain.entity.ProduccionDiaria;
import java.util.Optional;

public interface ProduccionDiariaService {
    void createProduccionDiaria(ProduccionDiaria produccionDiaria);
    Optional<ProduccionDiaria> readProduccionDiaria(int gallinaId, java.sql.Date fecha);
    void updateProduccionDiaria(ProduccionDiaria produccionDiaria, int produccionId);
    void deleteProduccionDiaria(int produccionId);
}
