package com.backendSpring.BackendSpring.Repository;

import com.backendSpring.BackendSpring.entity.Notification;
import com.backendSpring.BackendSpring.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByEtudiantId(long id);
    List<Notification> findByEntrepriseId(long id);
    List<Notification> findByType(Type type);
}
