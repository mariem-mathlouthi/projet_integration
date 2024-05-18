package com.backendSpring.BackendSpring.Service;

import com.backendSpring.BackendSpring.Repository.OffreRepository;
import com.backendSpring.BackendSpring.dto.OffreDTO;
import com.backendSpring.BackendSpring.entity.Offre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OffreService {

    @Autowired
    private OffreRepository offreRepository;

    public Offre ajouterOffre(Offre offre) {
        return offreRepository.save(offre);
    }

    public List<Offre> getOffresByEntrepriseId(long entrepriseId) {
        return offreRepository.findByEntrepriseId(entrepriseId);
    }
    public List<Offre> getAllOffres() {
        return offreRepository.findAll();
    }

    public Offre getOffreDetails(Long offreId) {
        return offreRepository.findById(offreId)
                .orElseThrow(() -> new RuntimeException("Offre not found"));
    }


    public boolean updateOffre(OffreDTO offreDTO) {
        Optional<Offre> optionalOffre = offreRepository.findById(offreDTO.getId());

        if (optionalOffre.isPresent()) {
            Offre existingOffre = optionalOffre.get();
            existingOffre.setStatus(offreDTO.getStatus());
            existingOffre.setTitre(offreDTO.getTitre());
            existingOffre.setDescription(offreDTO.getDescription());
            existingOffre.setDomaine(offreDTO.getDomaine());
            existingOffre.setDateDebut(offreDTO.getDateDebut());
            existingOffre.setDateFin(offreDTO.getDateFin());
            existingOffre.setTypeOffre(offreDTO.getTypeOffre());
            existingOffre.setCahierCharge(offreDTO.getCahierCharge());

            offreRepository.save(existingOffre);
            return true; // La mise à jour a réussi
        } else {
            return false; // L'offre n'a pas été trouvée
        }
    }

    public void supprimerOffre(Long id) {
        offreRepository.deleteById(id);
    }



    public Offre getOffreDetailsForEntreprise(Long entrepriseId, Long offreId) {
        Offre offre = offreRepository.findByIdAndEntrepriseId(offreId, entrepriseId)
                .orElseThrow(() -> new RuntimeException("Offre not found for the specified entreprise"));
        return offre;
    }


    public ArrayList<Offre> chercherDesOffres(int searchType, String StringToSearch) {
        StringToSearch = StringToSearch.toLowerCase();
        ArrayList<Offre> SearchResult = new ArrayList<>();
        for (Offre e : offreRepository.findAll()) {
            if (searchType == 1 && e.getTitre().toLowerCase().contains(StringToSearch)) {
                SearchResult.add(e);
            } else if (searchType == 2 && e.getDescription().toLowerCase().contains(StringToSearch)) {
                SearchResult.add(e);
            } else if (searchType == 3 && e.getEntreprise().getName().toLowerCase().contains(StringToSearch)) {
                SearchResult.add(e);
            }
        }
        return SearchResult;
    }


    public ResponseEntity<Map<String, Object>> getOffreDetailById(Long id) {
        Optional<Offre> optionalOffre = offreRepository.findById(id);

        if (optionalOffre.isPresent()) {
            Offre offre = optionalOffre.get();

            Map<String, Object> response = new HashMap<>();
            response.put("offre", offre);
            response.put("message", "Offre details fetched successfully");
            response.put("check", true);

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}