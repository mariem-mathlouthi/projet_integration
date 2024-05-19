package com.backendSpring.BackendSpring.Controller;

import com.backendSpring.BackendSpring.Service.EntrepriseService;
import com.backendSpring.BackendSpring.dto.ApiResponse;
import com.backendSpring.BackendSpring.entity.Entreprise;
import com.backendSpring.BackendSpring.entity.EntreprisePayload;
import com.backendSpring.BackendSpring.entity.Offre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entreprise")
public class EntrepriseController {

    @Autowired
    private EntrepriseService entrepriseService;
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/Add")
    public ResponseEntity<?> AddEntreprise(@RequestBody EntreprisePayload entreprise) {
        entrepriseService.AddEntreprise(entreprise);
        return ResponseEntity.ok().body("User Created");
    }

    @PostMapping("/modify")
    public ResponseEntity<?> modifyEntrepriseInfo(@RequestBody Entreprise entreprise) {
        ResponseEntity<ApiResponse> responseEntity = entrepriseService.modifyEntrepriseInfo(entreprise);
        return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entreprise> getEntrepriseDetails(@PathVariable Long id) {
        Entreprise entreprise = entrepriseService.getEntrepriseDetails(id);
        if (entreprise!= null) {
            return new ResponseEntity<>(entreprise, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
