package com.backendSpring.BackendSpring.Controller;

import com.backendSpring.BackendSpring.Service.NotificationService;
import com.backendSpring.BackendSpring.entity.Notification;
import com.backendSpring.BackendSpring.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {
    @Autowired
    NotificationService notificationService;

    @GetMapping("/demandes/{idEtudiant}")
    public ResponseEntity<?> getNotificationsDemande(@PathVariable long idEtudiant) {
        return ResponseEntity.ok(notificationService.getNotificationsDemande(idEtudiant));
    }
    @GetMapping("/{type}")
    public ResponseEntity<?> getNotificationsOffre(@PathVariable Type type) {
        return ResponseEntity.ok(notificationService.getNotifications(type));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNotification(@RequestBody Notification notification) {
        return ResponseEntity.ok(notificationService.addNotification(notification));
    }
}
