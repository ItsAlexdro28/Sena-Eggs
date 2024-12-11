package com.eggtracker.modules.gallina.aplication;

import com.eggtracker.modules.gallina.domain.entity.Gallina;
import com.eggtracker.modules.gallina.domain.service.GallinaService;
import java.util.Optional;

public class ReadGallinaUC {
    private GallinaService gallinaService;

    public ReadGallinaUC(GallinaService gallinaService) {
        this.gallinaService = gallinaService;
    }

    public Optional<Gallina> execute(int gallinaId) {
        return gallinaService.readGallina(gallinaId);
    }
}
