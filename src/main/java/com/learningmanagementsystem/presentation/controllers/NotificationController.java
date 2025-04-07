package com.learningmanagementsystem.presentation.controllers;

import com.learningmanagementsystem.application.usecases.GetUserNotificationsUseCase;
import com.learningmanagementsystem.application.usecases.SendNotificationUseCase;
import com.learningmanagementsystem.domain.entity.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    private SendNotificationUseCase sendNotificationUseCase;

    private GetUserNotificationsUseCase getUserNotificationsUseCase;

    @Autowired
    public NotificationController(SendNotificationUseCase sendNotificationUseCase, GetUserNotificationsUseCase getUserNotificationsUseCase) {
        this.sendNotificationUseCase = sendNotificationUseCase;
        this.getUserNotificationsUseCase = getUserNotificationsUseCase;
    }

    @PostMapping
    public ResponseEntity<?> sendNotification(){
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<?> getUserNotifications(@RequestParam("is_read") String isRead){
        List<Notification> notifications = getUserNotificationsUseCase.execute(!Objects.equals(isRead, "false"));
        return ResponseEntity.ok(notifications);
    }

}
