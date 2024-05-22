package com.backendSpring.BackendSpring.Service;

import com.backendSpring.BackendSpring.Repository.NotificationRepository;
import com.backendSpring.BackendSpring.entity.Notification;
import com.backendSpring.BackendSpring.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getNotificationsDemande(Long idEtudiant)  {
        return notificationRepository.findByEtudiantId(idEtudiant);
    }
    public List<Notification> getNotifications(Type T) {
        return notificationRepository.findByType(T);
    }

    public Notification addNotification(Notification notification) {
        return notificationRepository.save(notification);
    }
}
