package com.Backend.controller;

import com.Backend.entities.Demande;
import com.Backend.service.DemandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demandes")
@RequiredArgsConstructor
@CrossOrigin("*")
public class DemandeController {
    //
    private final DemandeService demandeService;

    @PostMapping("/save")
    public Demande createDemande(@RequestBody Demande demande) {
        return demandeService.addDemande(demande);
    }

    //
    @GetMapping("")
    public List<Demande> readAllDemandes() {
        return demandeService.getAllDemandes();
    }

    //
    @DeleteMapping("/delete/{id}")
    public void supprimerDemande(@PathVariable Long id) {
        demandeService.deleteDemande(id);
    }

    //
    @GetMapping("/detail/{id}")
    public ResponseEntity<Demande> getDemandeById(@PathVariable Long id) {
        Demande demande = demandeService.getDemandeById(id);
        if (demande == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(demande);
    }

    //
    @PutMapping("/update/{id}")
    public ResponseEntity<Demande> getDemandeById(@PathVariable Long id, @RequestBody Demande demande) {
        Demande updateDemande = demandeService.updateDemande(id, demande);
        if (updateDemande == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok(updateDemande);
    }
    //
}
