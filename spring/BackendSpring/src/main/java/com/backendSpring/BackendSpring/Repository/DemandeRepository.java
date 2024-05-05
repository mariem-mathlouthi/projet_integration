package com.backendSpring.BackendSpring.Repository;

import com.backendSpring.BackendSpring.entity.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Long> {
}
