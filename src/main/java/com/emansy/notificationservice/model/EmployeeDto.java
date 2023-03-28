package com.emansy.notificationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class EmployeeDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private JobTitleDto jobTitleDto;

    private OfficeDto officeDto;

    private String workingStartTime;

    private String workingEndTime;

    private Set<Long> eventIds;
}
