package com.backend.controller;

import com.backend.entities.Demande;
import com.backend.service.DemandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demandes")
@RequiredArgsConstructor
@CrossOrigin("*")
public class DemandeController {

    private final DemandeService demandeService;

    @GetMapping("/")
    ResponseEntity<List<Demande>> getAllDemandes() {
        return ResponseEntity.ok(this.demandeService.getAllDemandes());
    }

    @GetMapping("/{id}")
    ResponseEntity<Demande> getDemandeById(@PathVariable("id") long id) {
        return ResponseEntity.ok(this.demandeService.getOneDemande(id));
    }

    @PostMapping("/")
    ResponseEntity<Long> saveDemade(@RequestBody @Validated Demande demande) {
        return ResponseEntity.ok(this.demandeService.createOrUpdateDemande(demande));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteDemande(@PathVariable("id") long id) {
        this.demandeService.deleteDemande(id);
        return ResponseEntity.accepted().build();
    }
}
