package com.emansy.notificationservice.business.service.impl;

import com.emansy.notificationservice.business.repository.NotificationRepository;
import com.emansy.notificationservice.business.repository.model.NotificationEntity;
import com.emansy.notificationservice.model.AttendeesDto;
import com.emansy.notificationservice.model.EmployeeDto;
import com.emansy.notificationservice.model.EventDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class NotificationServiceTest {

    @Mock
    private NotificationRepository repository;

    @InjectMocks
    private NotificationServiceImpl service;

    private AttendeesDto attendeesDto;

    private Set<EmployeeDto> employeeDtos;

    private EventDto eventDto;

    @BeforeEach
    public void init() {
        eventDto = createEventDto();
        employeeDtos = createEmployeeDtos();
        attendeesDto = createAttendeesDto(true, employeeDtos, eventDto);
    }

    @Test
    void saveNotificationTest() {
        service.saveNotification(attendeesDto);
        verify(repository, times(2)).save(any(NotificationEntity.class));
    }

    private AttendeesDto createAttendeesDto(Boolean whetherToAttendOrToUnattend, Set<EmployeeDto> employeeDtos, EventDto eventDto) {
        AttendeesDto attendeesDto = new AttendeesDto();
        attendeesDto.setWhetherToAttendOrToUnattend(whetherToAttendOrToUnattend);
        attendeesDto.setEmployeeDtos(employeeDtos);
        attendeesDto.setEventDto(eventDto);
        return attendeesDto;
    }

    private Set<EmployeeDto> createEmployeeDtos() {
        Set<EmployeeDto> employeeDtos = new HashSet<>();
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDtos.add(employeeDto);
        EmployeeDto anotherEmployeeDto = new EmployeeDto();
        anotherEmployeeDto.setId(2L);
        employeeDtos.add(anotherEmployeeDto);
        return employeeDtos;
    }

    private EventDto createEventDto() {
        EventDto eventDto = new EventDto();
        eventDto.setId(1L);
        return eventDto;
    }
}
