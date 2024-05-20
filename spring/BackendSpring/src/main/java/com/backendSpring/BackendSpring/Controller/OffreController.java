package com.backendSpring.BackendSpring.Controller;

import com.backendSpring.BackendSpring.Service.OffreService;
import com.backendSpring.BackendSpring.dto.OffreDTO;
import com.backendSpring.BackendSpring.entity.Demande;
import com.backendSpring.BackendSpring.entity.Offre;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/offres")
public class OffreController {

    private final OffreService offreService;

    public OffreController(OffreService offreService) {
        this.offreService = offreService;
    }
    @CrossOrigin(origins = "http://localhost:5174")
    @PostMapping("/add")
    public ResponseEntity<Offre> ajouterOffre(@RequestBody Offre offre) {
        Offre nouvelleOffre = offreService.ajouterOffre(offre);
        return ResponseEntity.ok(nouvelleOffre);
    }

    @GetMapping("/all/{entrepriseId}")
    public ResponseEntity<List<Offre>> afficherOffresParEntreprise(@PathVariable("entrepriseId") long entrepriseId) {
        List<Offre> offres = offreService.getOffresByEntrepriseId(entrepriseId);
        return ResponseEntity.ok(offres);
    }



    @GetMapping("/{entrepriseId}/{offreId}")
    public ResponseEntity<Offre> getOffreDetailsForEntreprise(@PathVariable("entrepriseId") Long entrepriseId,
                                                              @PathVariable("offreId") Long offreId) {
        Offre offre = offreService.getOffreDetailsForEntreprise(entrepriseId, offreId);
        return ResponseEntity.ok(offre);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Offre>> afficherTousOffres() {
        List<Offre> offres = offreService.getAllOffres();
        return ResponseEntity.ok(offres);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Offre> getOffreDetails(@PathVariable Long id) {
        Offre offre = offreService.getOffreDetails(id);
        if (offre != null) {
            return new ResponseEntity<>(offre, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/updateOffre")
    public ResponseEntity<Map<String, Object>> updateOffre(@RequestBody OffreDTO offreDTO) {
        boolean isUpdated = offreService.updateOffre(offreDTO);
        Map<String, Object> response = new HashMap<>();

        if (isUpdated) {
            response.put("message", "Offre updated successfully");
            response.put("update", true);
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Offre not found");
            response.put("update", false);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> supprimerOffre(@PathVariable Long id) {
        offreService.supprimerOffre(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find/{type}/{search}")
    public ResponseEntity<?> findOffres(@PathVariable int type,@PathVariable String search) {
        return ResponseEntity.ok(offreService.chercherDesOffres(type,search));
    }


    @GetMapping("/offreDetail2/{id}")
    public ResponseEntity<Map<String, Object>> getOffreDetail2(@PathVariable Long id) {
        return offreService.getOffreDetailById(id);
    }

}
