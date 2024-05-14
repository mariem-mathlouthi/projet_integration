package com.backendSpring.BackendSpring.Service;

import com.backendSpring.BackendSpring.Repository.OffreRepository;
import com.backendSpring.BackendSpring.entity.Offre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OffreService {

    @Autowired
    private OffreRepository offreRepository;

    public Offre ajouterOffre(Offre offre) {
        return offreRepository.save(offre);
    }
    public List<Offre> getAllOffres() {
        return offreRepository.findAll();
    }
    public Offre modifierOffre(Long id, Offre offreModifiee) {
        Optional<Offre> optionalOffre = offreRepository.findById(id);
        if (optionalOffre.isPresent()) {
            Offre offreExistante = optionalOffre.get();
            offreExistante.setStatus(offreModifiee.getStatus());
            offreExistante.setTitre(offreModifiee.getTitre());
            offreExistante.setDescription(offreModifiee.getDescription());
            offreExistante.setDomaine(offreModifiee.getDomaine());
            offreExistante.setDateDebut(offreModifiee.getDateDebut());
            offreExistante.setDateFin(offreModifiee.getDateFin());
            offreExistante.setTypeOffre(offreModifiee.getTypeOffre());
            offreExistante.setCahierCharge(offreModifiee.getCahierCharge());
            return offreRepository.save(offreExistante);
        } else {

            return null;
        }
    }
    public void supprimerOffre(Long id) {
        offreRepository.deleteById(id);
    }
    public Offre getOffreDetails(Long offreId) {
        return offreRepository.findById(offreId)
                .orElseThrow(() -> new RuntimeException("Offre not found"));
    }



}