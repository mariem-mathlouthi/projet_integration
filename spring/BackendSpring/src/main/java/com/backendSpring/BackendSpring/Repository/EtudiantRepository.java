package com.backendSpring.BackendSpring.Repository;

import com.backendSpring.BackendSpring.entity.Entreprise;
import com.backendSpring.BackendSpring.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
  /*  boolean existsByEmail(String email);
    boolean existsByCin(String cin);
    Optional<Etudiant> findByEmail(String email);
*/
    @Query(value="select * from etudiants where user_id=:id",nativeQuery=true)
    Etudiant getEtudianteByIdUser(Long id);
}
