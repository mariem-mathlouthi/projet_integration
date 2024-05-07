package com.backendSpring.BackendSpring.Service;

import com.backendSpring.BackendSpring.Repository.EtudiantRepository;
import com.backendSpring.BackendSpring.dto.ApiResponse;
import com.backendSpring.BackendSpring.entity.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class EtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;


    public boolean signUpEtudiant(String fullname, String niveau, String cin, String email, String password, String domaine, String typeStage, String specialite, String etablissement, String image) {

        if (etudiantRepository.existsByEmail(email)) {
            return false;
        }


        Etudiant etudiant = new Etudiant();
        etudiant.setFullname(fullname);
        etudiant.setNiveau(niveau);
        etudiant.setCin(cin);
        etudiant.setEmail(email);
        etudiant.setPassword(password);
        etudiant.setDomaine(domaine);
        etudiant.setTypeStage(typeStage);
        etudiant.setSpecialite(specialite);
        etudiant.setEtablissement(etablissement);
        etudiant.setImage(image);


        etudiantRepository.save(etudiant);
        return true;
    }

    public ResponseEntity<ApiResponse> modifyEtudiantInfo(Etudiant etudiant) {
        Optional<Etudiant> existingEtudiant = etudiantRepository.findByEmail(etudiant.getEmail());
        if (existingEtudiant.isPresent()) {
            Etudiant existing = existingEtudiant.get();
            existing.setFullname(etudiant.getFullname());
            existing.setNiveau(etudiant.getNiveau());
            existing.setCin(etudiant.getCin());
            existing.setPassword(etudiant.getPassword());
            existing.setDomaine(etudiant.getDomaine());
            existing.setTypeStage(etudiant.getTypeStage());
            existing.setSpecialite(etudiant.getSpecialite());
            existing.setEtablissement(etudiant.getEtablissement());
            existing.setImage(etudiant.getImage());
            etudiantRepository.save(existing);
            return ResponseEntity.ok().body(new ApiResponse("Account updated successfully", true));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Etudiant not found", false));
        }
    }



}
