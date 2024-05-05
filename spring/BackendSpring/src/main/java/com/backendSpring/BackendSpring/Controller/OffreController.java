package com.backendSpring.BackendSpring.Controller;

import com.backendSpring.BackendSpring.Service.OffreService;
import com.backendSpring.BackendSpring.entity.Offre;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offres")
public class OffreController {

    private final OffreService offreService;

    public OffreController(OffreService offreService) {
        this.offreService = offreService;
    }

    @PostMapping("/add")
    public ResponseEntity<Offre> ajouterOffre(@RequestBody Offre offre) {
        Offre nouvelleOffre = offreService.ajouterOffre(offre);
        return ResponseEntity.ok(nouvelleOffre);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Offre>> afficherTousOffres() {
        List<Offre> offres = offreService.getAllOffres();
        return ResponseEntity.ok(offres);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Offre> modifierOffre(@PathVariable Long id, @RequestBody Offre offreModifiee) {
        Offre offreModifieeResult = offreService.modifierOffre(id, offreModifiee);
        if (offreModifieeResult != null) {
            return ResponseEntity.ok(offreModifieeResult);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> supprimerOffre(@PathVariable Long id) {
        offreService.supprimerOffre(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{offreId}")
    public ResponseEntity<?> getOffreDetails(@PathVariable Long offreId) {
        Offre offre = offreService.getOffreDetails(offreId);
        return ResponseEntity.ok(offre);
    }
}
