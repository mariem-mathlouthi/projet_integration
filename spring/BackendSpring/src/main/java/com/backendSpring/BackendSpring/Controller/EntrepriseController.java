package com.backendSpring.BackendSpring.Controller;

import com.backendSpring.BackendSpring.Service.EntrepriseService;
import com.backendSpring.BackendSpring.dto.ApiResponse;
import com.backendSpring.BackendSpring.entity.Entreprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/entreprise")
public class EntrepriseController {

    @Autowired
    private EntrepriseService entrepriseService;

    @PutMapping("/modify")
    public ResponseEntity<ApiResponse> modifyEntrepriseInfo(@RequestBody Entreprise entreprise) {
        ResponseEntity<ApiResponse> responseEntity = entrepriseService.modifyEntrepriseInfo(entreprise);
        return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
    }

}
