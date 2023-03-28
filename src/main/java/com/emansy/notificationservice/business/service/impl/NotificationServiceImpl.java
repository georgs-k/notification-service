package com.emansy.notificationservice.business.service.impl;

import com.emansy.notificationservice.business.repository.NotificationRepository;
import com.emansy.notificationservice.business.repository.model.NotificationEntity;
import com.emansy.notificationservice.business.service.NotificationService;
import com.emansy.notificationservice.model.AttendeesDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Log4j2
@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public void saveNotification(AttendeesDto attendeesDto) {
        Boolean attendOrUnattend = attendeesDto.getWhetherToAttendOrToUnattend();
        Long eventId = attendeesDto.getEventDto().getId();
        attendeesDto.getEmployeeDtos().forEach(employeeDto -> notificationRepository.save(
                new NotificationEntity(null, LocalDateTime.now(), attendOrUnattend, employeeDto.getId(), eventId)));
        log.info("Notification data for {} employees' attendance of event with id {} is saved",
                attendeesDto.getEmployeeDtos().size(), eventId);
    }
}
