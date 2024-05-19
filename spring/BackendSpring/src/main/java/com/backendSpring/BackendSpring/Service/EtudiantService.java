package com.backendSpring.BackendSpring.Service;

import com.backendSpring.BackendSpring.Repository.EtudiantRepository;
import com.backendSpring.BackendSpring.Repository.UserRepository;
import com.backendSpring.BackendSpring.SpringSecurity.SecurityConfig;
import com.backendSpring.BackendSpring.dto.ApiResponse;
import com.backendSpring.BackendSpring.entity.Etudiant;
import com.backendSpring.BackendSpring.entity.EtudiantPayload;
import com.backendSpring.BackendSpring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service

public class EtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private SecurityConfig securityConfig;

    @Autowired
    private UserRepository UserRepo;
    public boolean signUpEtudiant(EtudiantPayload e) {
            User user=new User();
            user.setEmail(e.getEmail());
            user.setPassword(securityConfig.passwordEncoder().encode(e.getPassword()));
            user.setRole("Etudiant");
            Etudiant etudiant = new Etudiant();
            etudiant.setFullname(e.getFullname());
            etudiant.setNiveau(e.getNiveau());
            etudiant.setCin(e.getCin());
            etudiant.setDomaine(e.getDomaine());
            etudiant.setTypeStage(e.getTypeStage());
            etudiant.setSpecialite(e.getSpecialite());
            etudiant.setEtablissement(e.getEtablissement());
            etudiant.setImage(e.getImage());
            etudiant.setUser(UserRepo.save(user));
            etudiantRepository.save(etudiant);
            return true;

    }

    public ResponseEntity<ApiResponse> modifyEtudiantInfo(Etudiant etudiant) {
        Optional<Etudiant> existingEtudiant = etudiantRepository.findById(etudiant.getId());
        if (existingEtudiant.isPresent()) {
            Etudiant existing = existingEtudiant.get();
            existing.setFullname(etudiant.getFullname());
            existing.setNiveau(etudiant.getNiveau());
            existing.setCin(etudiant.getCin());

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


    public ResponseEntity<Map<String, Object>> getStudentDetail(Long id) {
        Optional<Etudiant> optionalEtudiant = etudiantRepository.findById(id);

        if (optionalEtudiant.isPresent()) {
            Etudiant student = optionalEtudiant.get();
            Map<String, Object> response = new HashMap<>();
            response.put("student", student);
            response.put("message", "Student detail fetched successfully");
            response.put("check", true);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
