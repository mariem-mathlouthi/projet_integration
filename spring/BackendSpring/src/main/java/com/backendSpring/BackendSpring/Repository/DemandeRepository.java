package com.backendSpring.BackendSpring.Repository;

import com.backendSpring.BackendSpring.entity.Demande;
import com.backendSpring.BackendSpring.entity.Statuts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Long> {


    List<Demande> findByStatut(Statuts statuts);
    List<Demande> findByEtudiantId(long id);
    List<Demande> findByOffreDeStageId(Long offerId);
}
