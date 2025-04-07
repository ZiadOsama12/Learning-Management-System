package com.learningmanagementsystem.infrastructure.repo;

import com.learningmanagementsystem.domain.entity.Notification;
import com.learningmanagementsystem.domain.repository.NotificationRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaNotificationRepo extends NotificationRepo, JpaRepository<Notification, Long> {
}
