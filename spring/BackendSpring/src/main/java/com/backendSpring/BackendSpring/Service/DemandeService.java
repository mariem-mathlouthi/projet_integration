package com.backendSpring.BackendSpring.Service;

import com.backendSpring.BackendSpring.Exception.DemandeNotFoundException;
import com.backendSpring.BackendSpring.Repository.DemandeRepository;
import com.backendSpring.BackendSpring.entity.Demande;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeService {
    private final DemandeRepository demandeRepository;

    public DemandeService(DemandeRepository demandeRepository) {
        this.demandeRepository = demandeRepository;
    }

    public List<Demande> getAllDemandesDeStage() {
        return demandeRepository.findAll();
    }
    public Demande getDemandeDetails(Long id) {
        Optional<Demande> demandeOptional = demandeRepository.findById(id);
        return demandeOptional.orElse(null);
    }

    public void accepterEtudiant(Long demandeId, Long etudiantId) {
        Optional<Demande> demandeOptional = demandeRepository.findById(demandeId);
        if (demandeOptional.isPresent()) {
            Demande demande = demandeOptional.get();
            demande.setStatus("accepté");
            demandeRepository.save(demande);
        } else {
            throw new DemandeNotFoundException("La demande avec l'ID " + demandeId + " n'a pas été trouvée.");
        }
    }

    public void rejeterDemande(Long demandeId) {
        Optional<Demande> demandeOptional = demandeRepository.findById(demandeId);
        if (demandeOptional.isPresent()) {
            Demande demande = demandeOptional.get();

            demande.setStatus("rejeté");

            demandeRepository.save(demande);
        } else {

            throw new DemandeNotFoundException("La demande avec l'ID " + demandeId + " n'a pas été trouvée.");
        }
    }

    public void mettreEnAttenteDemande(Long demandeId) {
        Optional<Demande> demandeOptional = demandeRepository.findById(demandeId);
        if (demandeOptional.isPresent()) {
            Demande demande = demandeOptional.get();

            demande.setStatus("en attente");

            demandeRepository.save(demande);
        } else {
            throw new DemandeNotFoundException("La demande avec l'ID " + demandeId + " n'a pas été trouvée.");
        }
    }



}
