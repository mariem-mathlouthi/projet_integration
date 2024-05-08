package com.backendSpring.BackendSpring.Service;

import com.backendSpring.BackendSpring.Exception.DemandeNotFoundException;
import com.backendSpring.BackendSpring.Repository.DemandeRepository;
import com.backendSpring.BackendSpring.entity.Demande;
import com.backendSpring.BackendSpring.entity.Statuts;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Demande getDemandeDetails(Long id) {
        Optional<Demande> demandeOptional = demandeRepository.findById(id);
        return demandeOptional.orElse(null);
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

    public void mettreEnAttenteDemande(Long demandeId) {
        Optional<Demande> demandeOptional = demandeRepository.findById(demandeId);
        if (demandeOptional.isPresent()) {
            Demande demande = demandeOptional.get();
            demande.setStatus(Statuts.en_attente); // Assuming en_attente is a valid value in Statuts enum
            demandeRepository.save(demande);
        } else {
            throw new DemandeNotFoundException("La demande avec l'ID " + demandeId + " n'a pas été trouvée.");
        }
    }
    public void setStatus(Statuts statut) {
        this.statut = statut;
    }

    public List<Demande> getDemandesEnAttente() {
        return demandeRepository.findByStatut(Statuts.en_attente);
    }

    public List<Demande> getDemandesAcceptees() {
        return demandeRepository.findByStatut(Statuts.accepté);
    }

    public List<Demande> getDemandesRefusees() {
        return demandeRepository.findByStatut(Statuts.refusé);
    }



}
