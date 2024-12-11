package com.eggtracker.modules.gallina.domain.service;

import java.util.Optional;

import com.eggtracker.modules.gallina.domain.entity.Gallina;

public interface GallinaService {
    void createGallina(Gallina gallina);
    Optional<Gallina> readGallina(int gallinaId);
    void updateGallina(Gallina gallina, int id);
    void deleteGallina(int gallinaId);
}
