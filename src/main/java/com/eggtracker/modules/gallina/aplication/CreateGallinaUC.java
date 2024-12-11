package com.eggtracker.modules.gallina.aplication;

import com.eggtracker.modules.gallina.domain.entity.Gallina;
import com.eggtracker.modules.gallina.domain.service.GallinaService;

public class CreateGallinaUC {
    private GallinaService gallinaService;

    public CreateGallinaUC(GallinaService gallinaService) {
        this.gallinaService = gallinaService;
    }

    public void execute(Gallina gallina) {
        gallinaService.createGallina(gallina);
    }
}
