package com.backendSpring.BackendSpring.Service;

import com.backendSpring.BackendSpring.Repository.EntrepriseRepository;
import com.backendSpring.BackendSpring.Repository.UserRepository;
import com.backendSpring.BackendSpring.SpringSecurity.SecurityConfig;
import com.backendSpring.BackendSpring.dto.ApiResponse;
import com.backendSpring.BackendSpring.entity.Entreprise;
import com.backendSpring.BackendSpring.entity.EntreprisePayload;
import com.backendSpring.BackendSpring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntrepriseService {

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @Autowired
    private SecurityConfig securityConfig;

    @Autowired
    private UserRepository UserRepo;

    public boolean AddEntreprise(EntreprisePayload entre){
        User user=new User();
        user.setEmail(entre.getEmail());
        user.setPassword(securityConfig.passwordEncoder().encode(entre.getPassword()));
        user.setRole("Entreprise");
        Entreprise new_entre=new Entreprise();
        new_entre.setDescription(entre.getDescription());
        new_entre.setName(entre.getName());
        new_entre.setLogo(entre.getLogo());
        new_entre.setSecteur(entre.getSecteur());
        new_entre.setNumeroSIRET(entre.getNumeroSIRET());
        new_entre.setLink(entre.getLink());
        new_entre.setUser(UserRepo.save(user));
        entrepriseRepository.save(new_entre);
return  true;
    }
    public ResponseEntity<ApiResponse> modifyEntrepriseInfo(Entreprise entreprise) {
       Optional<Entreprise> existingEntreprise = entrepriseRepository.findById(entreprise.getId());
        if (existingEntreprise.isPresent()) {
            Entreprise existing = existingEntreprise.get();
            existing.setNumeroSIRET(entreprise.getNumeroSIRET());
            existing.setName(entreprise.getName());
            existing.setSecteur(entreprise.getSecteur());
            existing.setDescription(entreprise.getDescription());
            existing.setLogo(entreprise.getLogo());
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
