package com.learningmanagementsystem.application.usecases;

import com.learningmanagementsystem.application.dto.SendNotificationRequestDTO;
import com.learningmanagementsystem.domain.entity.Notification;
import com.learningmanagementsystem.domain.repository.MyUserRepo;
import com.learningmanagementsystem.domain.repository.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendNotificationUseCase {
    @Autowired
    private NotificationRepo notificationRepo;
    @Autowired
    private MyUserRepo myUserRepo;

    public Notification execute(SendNotificationRequestDTO sendNotificationRequestDTO) {

        int userId = sendNotificationRequestDTO.getUserId();
        if (!myUserRepo.existsById((long) userId)) {
            throw new RuntimeException("User not found");
        }

        Notification notification = new Notification();
        notification.setMessage(sendNotificationRequestDTO.getMessage());
        notification.setUserId(sendNotificationRequestDTO.getUserId());
        notificationRepo.save(notification);
        return notification;
    }
}
