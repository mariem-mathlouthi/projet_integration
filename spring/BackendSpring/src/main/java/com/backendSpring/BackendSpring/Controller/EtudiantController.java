package com.backendSpring.BackendSpring.Controller;

import com.backendSpring.BackendSpring.Service.EtudiantService;
import com.backendSpring.BackendSpring.dto.ApiResponse;
import com.backendSpring.BackendSpring.entity.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
    @Autowired
    private EtudiantService etudiantService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUpEtudiant(@RequestParam String fullname, @RequestParam String niveau, @RequestParam String cin, @RequestParam String email, @RequestParam String password, @RequestParam String domaine, @RequestParam String typeStage, @RequestParam String specialite, @RequestParam String etablissement, @RequestParam String image) {
        if (etudiantService.signUpEtudiant(fullname, niveau, cin, email, password, domaine, typeStage, specialite, etablissement, image)) {
            return ResponseEntity.ok("Account created successfully");
        } else {
            return ResponseEntity.badRequest().body("Email already exists");
        }
    }

    @PutMapping("/modify")
    public ResponseEntity<ApiResponse> modifyEtudiantInfo(@RequestBody Etudiant etudiant) {
        ResponseEntity<ApiResponse> responseEntity = etudiantService.modifyEtudiantInfo(etudiant);
        return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
    }


}
