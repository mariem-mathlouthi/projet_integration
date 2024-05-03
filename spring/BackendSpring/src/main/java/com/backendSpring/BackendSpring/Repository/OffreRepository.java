package com.backendSpring.BackendSpring.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backendSpring.BackendSpring.entity.Offre;

@Repository
public interface OffreRepository extends JpaRepository<Offre, Long> {

}
