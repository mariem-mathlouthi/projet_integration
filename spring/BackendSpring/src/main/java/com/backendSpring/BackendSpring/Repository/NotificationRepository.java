package com.backendSpring.BackendSpring.Repository;

import com.backendSpring.BackendSpring.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
