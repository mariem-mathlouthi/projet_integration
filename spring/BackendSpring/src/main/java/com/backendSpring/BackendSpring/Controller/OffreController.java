package com.backendSpring.BackendSpring.Controller;

import com.backendSpring.BackendSpring.Service.OffreService;
import com.backendSpring.BackendSpring.entity.Demande;
import com.backendSpring.BackendSpring.entity.Offre;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/{id}")
    public ResponseEntity<Offre> getDemandeDetails(@PathVariable Long id) {
        Offre offre = offreService.getOffreDetails(id);
        if (offre != null) {
            return new ResponseEntity<>(offre, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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

    @GetMapping("/find/{type}/{search}")
    public ResponseEntity<?> findOffres(@PathVariable int type,@PathVariable String search) {
        return ResponseEntity.ok(offreService.chercherDesOffres(type,search));
    }

}
