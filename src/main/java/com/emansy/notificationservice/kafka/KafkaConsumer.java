package com.emansy.notificationservice.kafka;

import com.emansy.notificationservice.business.service.NotificationService;
import com.emansy.notificationservice.model.AttendeesDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@RequiredArgsConstructor
@Component
public class KafkaConsumer {

    private final NotificationService notificationService;

    @KafkaListener(topics = "attendance-notification", groupId = "notification-group")
    public void handleAttendanceNotificationRequest(AttendeesDto attendeesDto) {
        log.info("Attendance notification request for {} employees is received from kafka topic: attendance-notification",
                attendeesDto.getEmployeeDtos().size());
        notificationService.saveNotification(attendeesDto);
    }
}
