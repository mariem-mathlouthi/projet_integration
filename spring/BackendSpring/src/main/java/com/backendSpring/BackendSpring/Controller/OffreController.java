package com.backendSpring.BackendSpring.Controller;

import com.backendSpring.BackendSpring.Service.OffreService;
import com.backendSpring.BackendSpring.entity.Offre;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/offres")
public class OffreController {

    private final OffreService offreService;

    public OffreController(OffreService offreService) {
        this.offreService = offreService;
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Offre> ajouterOffre(@RequestBody Offre offre) {
        Offre nouvelleOffre = offreService.ajouterOffre(offre);
        return ResponseEntity.ok(nouvelleOffre);
    }
}
