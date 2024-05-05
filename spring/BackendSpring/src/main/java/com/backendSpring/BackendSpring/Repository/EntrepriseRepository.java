package com.backendSpring.BackendSpring.Repository;

import com.backendSpring.BackendSpring.entity.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
}
