package com.Backend.service;

import com.Backend.entities.Demande;
import com.Backend.repositories.DemandeRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class DemandeServiceIMPL implements DemandeService{
    //
    private final DemandeRepository demandeRepository;

    public DemandeServiceIMPL(DemandeRepository demandeRepository) {
        this.demandeRepository = demandeRepository;
    }
    //
    @Override
    public void createDemande(Demande demande) {
        this.demandeRepository.save(demande);
    }
    //
    @Override
    public List<Demande> getAllDemandes() {
        return this.demandeRepository.findAll();
    }

    @Override
    public void editDemande(Demande demande, Long id) {
        Demande dataDemande =  this.demandeRepository.getReferenceById(id);
        dataDemande.setTypePermission(demande.getTypePermission());
        dataDemande.setDureePermission(demande.getDureePermission());
        dataDemande.setDateDemande(demande.getDateDemande());
        dataDemande.setDateDebut(demande.getDateDebut());
        dataDemande.setDateFin(demande.getDateFin());
        dataDemande.setLibelle(demande.getLibelle());
        this.demandeRepository.save(dataDemande);
    }

    @Override
    public void deleteDemande(Long id) {
        this.demandeRepository.deleteById(id);
    }

    @Override
    public Demande getOneDemande(Long id) {
        return this.demandeRepository.getReferenceById(id);
    }

    // @Override
    // public Demande detailDemande(Long id) {
    //     return this.demandeRepository.getReferenceById(id);
    // }


}
