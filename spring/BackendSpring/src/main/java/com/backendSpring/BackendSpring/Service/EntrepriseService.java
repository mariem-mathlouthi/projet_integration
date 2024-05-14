package com.backendSpring.BackendSpring.Service;

import com.backendSpring.BackendSpring.Repository.EntrepriseRepository;
import com.backendSpring.BackendSpring.dto.ApiResponse;
import com.backendSpring.BackendSpring.entity.Entreprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntrepriseService {

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    public ResponseEntity<ApiResponse> modifyEntrepriseInfo(Entreprise entreprise) {
        Optional<Entreprise> existingEntreprise = entrepriseRepository.findByEmail(entreprise.getEmail());
        if (existingEntreprise.isPresent()) {
            Entreprise existing = existingEntreprise.get();
            existing.setNumeroSIRET(entreprise.getNumeroSIRET());
            existing.setName(entreprise.getName());
            existing.setSecteur(entreprise.getSecteur());
            existing.setDescription(entreprise.getDescription());
            entrepriseRepository.save(existing);
            return ResponseEntity.ok().body(new ApiResponse("Account updated successfully", true));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Entreprise not found", false));
        }
    }


    public Entreprise getEntrepriseDetails(Long entrepriseId) {
        return entrepriseRepository.findById(entrepriseId)
                .orElseThrow(() -> new RuntimeException("Entreprise not found"));
    }

}
