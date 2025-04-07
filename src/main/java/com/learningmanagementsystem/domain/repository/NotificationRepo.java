package com.learningmanagementsystem.domain.repository;

import com.learningmanagementsystem.domain.entity.Notification;

import java.util.List;

public interface NotificationRepo extends IBaseRepo<Notification, Long> {
    List<Notification> findByIsReadFalseAndUserId(Long userId);// means is_read = 0
    List<Notification> findByUserId(Long userId);

}
