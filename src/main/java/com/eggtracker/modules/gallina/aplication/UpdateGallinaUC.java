package com.eggtracker.modules.gallina.aplication;

import com.eggtracker.modules.gallina.domain.entity.Gallina;
import com.eggtracker.modules.gallina.domain.service.GallinaService;

public class UpdateGallinaUC {
    public final GallinaService gallinaService;

    public UpdateGallinaUC(GallinaService gallinaService) {
        this.gallinaService = gallinaService;
    }

    public void execute(Gallina gallina, int id) {
        gallinaService.updateGallina(gallina, id);
    }
}
