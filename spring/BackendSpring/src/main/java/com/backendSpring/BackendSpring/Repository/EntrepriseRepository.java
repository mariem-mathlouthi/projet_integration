package com.backendSpring.BackendSpring.Repository;

import com.backendSpring.BackendSpring.entity.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
    Optional<Entreprise> findByEmail(String email);
}
