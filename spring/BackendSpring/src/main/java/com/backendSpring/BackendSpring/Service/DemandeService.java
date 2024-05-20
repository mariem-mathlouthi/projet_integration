package com.backendSpring.BackendSpring.Service;

import com.backendSpring.BackendSpring.Exception.DemandeNotFoundException;
import com.backendSpring.BackendSpring.Repository.DemandeRepository;
import com.backendSpring.BackendSpring.entity.Demande;
import com.backendSpring.BackendSpring.entity.Statuts;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DemandeService {
    private final DemandeRepository demandeRepository;
    private Statuts statut;

    public DemandeService(DemandeRepository demandeRepository) {
        this.demandeRepository = demandeRepository;
    }

    public Demande ajouterDemande(Demande demande) {
        return demandeRepository.save(demande);
    }

    public List<Demande> getAllDemandesDeStage() {
        return demandeRepository.findAll();
    }
    public List<Demande> getDemandeByOfferId(Long offerId) {
        return demandeRepository.findByOffreDeStageId(offerId);
    }

    public void accepterEtudiant(Long demandeId, Long etudiantId) {
        Optional<Demande> demandeOptional = demandeRepository.findById(demandeId);
        if (demandeOptional.isPresent()) {
            Demande demande = demandeOptional.get();
            demande.setStatus(Statuts.accepté); // Assuming accepté is a valid value in Statuts enum
            demandeRepository.save(demande);
        } else {
            throw new DemandeNotFoundException("La demande avec l'ID " + demandeId + " n'a pas été trouvée.");
        }
    }


    
    public void rejeterDemande(Long demandeId) {
        Optional<Demande> demandeOptional = demandeRepository.findById(demandeId);
        if (demandeOptional.isPresent()) {
            Demande demande = demandeOptional.get();
            demande.setStatus(Statuts.refusé); // Assuming accepté is a valid value in Statuts enum
            demandeRepository.save(demande);
        } else {
            throw new DemandeNotFoundException("La demande avec l'ID " + demandeId + " n'a pas été trouvée.");
        }
    }

    public ResponseEntity<Map<String, Object>> updateStatut(Long id, Statuts statut) {
        Optional<Demande> optionalDemande = demandeRepository.findById(id);

        if (optionalDemande.isPresent()) {
            Demande existingDemande = optionalDemande.get();
            existingDemande.setStatut(statut);
            demandeRepository.save(existingDemande);

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Demande updated successfully");
            response.put("update", true);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public List<Demande>getDemandesEtudiant(Long id) {
        List<Demande> response = demandeRepository.findByEtudiantId(id);
        return response;
    }

    public Boolean deleteDemande(Long idDemande) {
        demandeRepository.deleteById(idDemande);
        return demandeRepository.existsById(idDemande);
    }






}
