package com.eggtracker.modules.gallina.aplication;

import com.eggtracker.modules.gallina.domain.service.GallinaService;

public class DeleteGallinaUC {
    private GallinaService gallinaService;

    public DeleteGallinaUC(GallinaService gallinaService) {
        this.gallinaService = gallinaService;
    }

    public void execute(int gallinaId) {
        gallinaService.deleteGallina(gallinaId);
    }
}
