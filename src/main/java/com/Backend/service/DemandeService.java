package com.Backend.service;

import com.Backend.entities.Demande;

import java.util.List;

public interface DemandeService {
    //
    //
    void createDemande(Demande demande);
    //
    List<Demande> getAllDemandes();
    //
    void editDemande(Demande demande, Long id);
    //
    void deleteDemande(Long id);
    //
    Demande getOneDemande(Long id);
    //
    // Demande detailDemande(Long id);
    //
}
