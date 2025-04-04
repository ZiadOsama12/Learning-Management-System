package com.learningmanagementsystem.presentation.controllers;

import com.learningmanagementsystem.application.usecases.GetUserNotificationsUseCase;
import com.learningmanagementsystem.application.usecases.SendNotificationUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<?> getUserNotifications(){
        return ResponseEntity.ok().build();
    }

}
