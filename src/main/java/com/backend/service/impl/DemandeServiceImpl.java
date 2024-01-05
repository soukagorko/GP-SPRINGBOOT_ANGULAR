package com.backend.service.impl;

import com.backend.entities.Demande;
import com.backend.repositories.DemandeRepository;
import com.backend.service.DemandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DemandeServiceImpl implements DemandeService {

    private final DemandeRepository demandeRepository;

    @Override
    public Long createOrUpdateDemande(Demande demande) {
        return this.demandeRepository.save(demande).getIdPermission();
    }

    @Override
    public List<Demande> getAllDemandes() {
        return this.demandeRepository.findAll();
    }

    @Override
    public Long editDemande(Demande demande, Long id) {

        Optional<Demande> demandeAMettreAjourOptional = null;

        demandeAMettreAjourOptional = this.demandeRepository.findById(id);

        if (demandeAMettreAjourOptional.isPresent()) {

            Demande demandeAMettreAjour = demandeAMettreAjourOptional.get();

            demandeAMettreAjour.setTypePermission(demande.getTypePermission());
            demandeAMettreAjour.setDureePermission(demande.getDureePermission());
            demandeAMettreAjour.setDateDemande(demande.getDateDemande());
            demandeAMettreAjour.setDateDebut(demande.getDateDebut());
            demandeAMettreAjour.setDateFin(demande.getDateFin());
            demandeAMettreAjour.setLibelle(demande.getLibelle());
            return this.demandeRepository.save(demandeAMettreAjour).getIdPermission();
        } else {
            return Long.valueOf(0);
        }
    }

    @Override
    public void deleteDemande(Long id) {
        this.demandeRepository.deleteById(id);
    }

    @Override
    public Demande getOneDemande(Long id) {

        Optional<Demande> demandeOptional = this.demandeRepository.findById(id);
        return demandeOptional.get();
    }
}
