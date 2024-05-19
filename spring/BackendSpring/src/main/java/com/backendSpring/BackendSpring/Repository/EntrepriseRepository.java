package com.backendSpring.BackendSpring.Repository;

import com.backendSpring.BackendSpring.entity.Admin;
import com.backendSpring.BackendSpring.entity.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {

    @Query(value="select * from entreprises where user_id=:id",nativeQuery=true)
    Entreprise getEntrepriseByIdUser(Long id);
}
