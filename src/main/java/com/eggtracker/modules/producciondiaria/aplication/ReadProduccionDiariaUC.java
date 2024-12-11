package com.eggtracker.modules.producciondiaria.aplication;

import com.eggtracker.modules.producciondiaria.domain.entity.ProduccionDiaria;
import com.eggtracker.modules.producciondiaria.domain.service.ProduccionDiariaService;
import java.util.Optional;

public class ReadProduccionDiariaUC {
    private ProduccionDiariaService produccionDiariaService;

    public ReadProduccionDiariaUC(ProduccionDiariaService produccionDiariaService) {
        this.produccionDiariaService = produccionDiariaService;
    }

    public Optional<ProduccionDiaria> execute(int gallinaId, java.sql.Date fecha) {
        return produccionDiariaService.readProduccionDiaria(gallinaId, fecha);
    }
}
