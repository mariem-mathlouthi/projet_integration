package com.backendSpring.BackendSpring.Service;

import com.backendSpring.BackendSpring.Repository.OffreRepository;
import com.backendSpring.BackendSpring.entity.Entreprise;
import com.backendSpring.BackendSpring.entity.Offre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OffreService {

    @Autowired
    private OffreRepository offreRepository;

    public Offre ajouterOffre(Offre offre) {
        return offreRepository.save(offre);
    }
}