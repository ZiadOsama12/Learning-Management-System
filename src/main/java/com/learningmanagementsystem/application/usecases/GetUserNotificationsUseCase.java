package com.learningmanagementsystem.application.usecases;

import com.learningmanagementsystem.domain.entity.Notification;
import com.learningmanagementsystem.domain.entity.Users;
import com.learningmanagementsystem.domain.repository.MyUserRepo;
import com.learningmanagementsystem.domain.repository.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUserNotificationsUseCase {
    @Autowired
    private NotificationRepo notificationRepo;
    @Autowired
    private MyUserRepo myUserRepo;

    public List<Notification> execute(boolean isRead) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Users user = myUserRepo.findByUsername(username);

        if(isRead){
            return notificationRepo.findByUserId((long) user.getId());
        }
        else{
            return notificationRepo.findByIsReadFalseAndUserId((long) user.getId());
        }
    }
}
