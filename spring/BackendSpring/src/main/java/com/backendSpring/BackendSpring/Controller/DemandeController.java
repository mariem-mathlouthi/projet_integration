package com.backendSpring.BackendSpring.Controller;

import com.backendSpring.BackendSpring.Service.DemandeService;
import com.backendSpring.BackendSpring.entity.Demande;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demandes")
public class DemandeController {
    private final DemandeService demandeService;

    public DemandeController(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Demande>> getAllDemandesDeStage() {
        List<Demande> demandes = demandeService.getAllDemandesDeStage();
        return ResponseEntity.ok().body(demandes);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Demande> getDemandeDetails(@PathVariable Long id) {
        Demande demande = demandeService.getDemandeDetails(id);
        if (demande != null) {
            return new ResponseEntity<>(demande, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/demandes/{demandeId}/accepter-etudiant/{etudiantId}")
    public ResponseEntity<String> accepterEtudiant(@PathVariable Long demandeId, @PathVariable Long etudiantId) {
        demandeService.accepterEtudiant(demandeId, etudiantId);
        return ResponseEntity.ok("La demande a été acceptée avec succès.");
    }

    @PutMapping("/demandes/{demandeId}/refuser")
    public ResponseEntity<String> refuserDemande(@PathVariable Long demandeId) {
        demandeService.rejeterDemande(demandeId);
        return ResponseEntity.ok("La demande a été rejeté avec succès.");
    }


    @PutMapping("/demandes/{demandeId}/mettre-en-attente")
    public ResponseEntity<String> mettreEnAttenteDemande(@PathVariable Long demandeId) {
        demandeService.mettreEnAttenteDemande(demandeId);
        return ResponseEntity.ok("La demande a été mise en attente avec succès.");
    }

}