package com.backendSpring.BackendSpring.Controller;

import com.backendSpring.BackendSpring.Service.DemandeService;
import com.backendSpring.BackendSpring.entity.Demande;
import com.backendSpring.BackendSpring.entity.Statuts;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/demandes")
public class DemandeController {
    private final DemandeService demandeService;

    public DemandeController(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    @PostMapping("/add")
    public ResponseEntity<Demande> ajouterDemande(@RequestBody Demande demande) {
        Demande nouvelleDemande = demandeService.ajouterDemande(demande);
        return ResponseEntity.ok(nouvelleDemande);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Demande>> getAllDemandesDeStage() {
        List<Demande> demandes = demandeService.getAllDemandesDeStage();
        return ResponseEntity.ok().body(demandes);
    }
    @GetMapping("/byOfferId/{offerId}")
    public ResponseEntity<Map<String, Object>> getDemandeByOfferId(@PathVariable Long offerId) {
        List<Demande> demandes = demandeService.getDemandeByOfferId(offerId);

        Map<String, Object> response = new HashMap<>();
        response.put("demandes", demandes);
        response.put("message", "Demandes fetched successfully");
        response.put("check", true);

        return ResponseEntity.ok(response);
    }


    @PutMapping("update/{id}/updateStatut")
    public ResponseEntity<Map<String, Object>> updateStatut(@PathVariable Long id, @RequestParam Statuts statut) {
        return demandeService.updateStatut(id, statut);
    }



    @GetMapping("/en-attente")
    public ResponseEntity<List<Demande>> getDemandesEnAttente() {
        List<Demande> demandes = demandeService.getDemandesEnAttente();
        return ResponseEntity.ok(demandes);
    }

    @GetMapping("/acceptees")
    public ResponseEntity<List<Demande>> getDemandesAcceptees() {
        List<Demande> demandes = demandeService.getDemandesAcceptees();
        return ResponseEntity.ok(demandes);
    }

    @GetMapping("/refusees")
    public ResponseEntity<List<Demande>> getDemandesRefusees() {
        List<Demande> demandes = demandeService.getDemandesRefusees();
        return ResponseEntity.ok(demandes);
    }

}
