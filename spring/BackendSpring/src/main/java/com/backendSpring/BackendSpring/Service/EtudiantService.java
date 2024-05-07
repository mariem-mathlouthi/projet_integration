package com.backendSpring.BackendSpring.Service;

import com.backendSpring.BackendSpring.Repository.EtudiantRepository;
import com.backendSpring.BackendSpring.entity.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



}
