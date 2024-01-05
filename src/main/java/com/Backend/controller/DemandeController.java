package com.Backend.controller;

import com.Backend.entities.Demande;
import com.Backend.service.DemandeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demandes")
//@RequiredArgsConstructor
@CrossOrigin("*")
public class DemandeController {
    //
    final DemandeService demandeService;

    public DemandeController(DemandeService demandeService) {
        this.demandeService = demandeService;
    }
    //
    @PostMapping("/save")
    void saveDemade(@RequestBody Demande demande) {
        Demande dataInput =  new Demande();
        dataInput.setTypePermission(demande.getTypePermission());
        dataInput.setDureePermission(demande.getDureePermission());
        dataInput.setDateDemande(demande.getDateDemande());
        dataInput.setDateDebut(demande.getDateDebut());
        dataInput.setDateFin(demande.getDateFin());
        dataInput.setLibelle(demande.getLibelle());
        this.demandeService.createDemande(demande);
    }

    @GetMapping("")
    List<Demande> listAllDemandes() {
        return this.demandeService.getAllDemandes();
    }

    @GetMapping("/detail/{id}")
    Demande findOneDemandeById(@PathVariable("id") long id) {
        return this.demandeService.getOneDemande(id);
    }

    @DeleteMapping("/delete/{id}")
    void deleteDemande(@PathVariable("id") long id) {
        this.demandeService.deleteDemande(id);
    }
}
