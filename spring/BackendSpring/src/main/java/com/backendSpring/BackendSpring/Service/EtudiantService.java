package com.backendSpring.BackendSpring.Service;

import com.backendSpring.BackendSpring.Repository.EtudiantRepository;
import com.backendSpring.BackendSpring.dto.ApiResponse;
import com.backendSpring.BackendSpring.entity.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service

public class EtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Value("${upload.directory}")
    String uploadDirectory;


    public boolean signUpEtudiant(Etudiant e) {

        if (etudiantRepository.existsByEmail(e.getEmail())) {
            return false;
        } else if (etudiantRepository.existsByCin(e.getCin())) {
            return false;
        } else {
            Etudiant etudiant = new Etudiant();
            etudiant.setFullname(e.getFullname());
            etudiant.setNiveau(e.getNiveau());
            etudiant.setCin(e.getCin());
            etudiant.setEmail(e.getEmail());
            etudiant.setPassword(e.getPassword());
            etudiant.setDomaine(e.getDomaine());
            etudiant.setTypeStage(e.getTypeStage());
            etudiant.setSpecialite(e.getSpecialite());
            etudiant.setEtablissement(e.getEtablissement());
            etudiant.setImage(e.getImage());
            etudiantRepository.save(etudiant);
            return true;
        }
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

    public boolean uploadFile(MultipartFile file) throws IOException {
        try {
            File F = new File(uploadDirectory + File.separator + file.getOriginalFilename());
            file.transferTo(F.toPath());
            return true;
        }
        catch (IOException e) {
            System.out.println(e);
            return  false;
        }
    }


}
