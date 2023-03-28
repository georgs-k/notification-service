package com.emansy.notificationservice.business.repository;

import com.emansy.notificationservice.business.repository.model.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {
}
