package com.Backend.service;

import com.Backend.entities.Demande;
import com.Backend.entities.Role;
import com.Backend.repositories.DemandeRepository;
import com.Backend.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DemandeService {
    private final DemandeRepository demandeRepository;

    public Demande addDemande(Demande demande) {
        return demandeRepository.save(demande);
    }
    public List<Demande> getAllDemandes() {
        return demandeRepository.findAll();
    }

    public void deleteDemande(Long id) {
        demandeRepository.deleteById(id);
    }

    public Demande getDemandeById(Long id) {
        return demandeRepository.findById(id).orElse(null);
    }

    public Demande updateDemande(Long id, Demande demande) {
        Optional<Demande> optionalDemande = demandeRepository.findById(id);
        if (optionalDemande.isPresent()) {
            Demande existingDemande = optionalDemande.get();
            existingDemande.setTyPepermission(demande.getTyPepermission());
            existingDemande.setDureePermission(demande.getDureePermission());
            existingDemande.setDateDemande(demande.getDateDemande());
            existingDemande.setDateDebut(demande.getDateDebut());
            existingDemande.setDateFin(demande.getDateFin());
            existingDemande.setLibelle(demande.getLibelle());
            return demandeRepository.save(existingDemande);
        }
        return null;
    }
    //
}
