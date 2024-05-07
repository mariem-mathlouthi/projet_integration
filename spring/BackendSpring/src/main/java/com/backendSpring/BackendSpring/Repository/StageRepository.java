package com.backendSpring.BackendSpring.Repository;

import com.backendSpring.BackendSpring.entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageRepository  extends JpaRepository<Stage, Long> {
}
