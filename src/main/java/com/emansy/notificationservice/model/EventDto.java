package com.emansy.notificationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class EventDto {

    private Long id;

    private String title;

    private String details;

    private String date;

    private String startTime;

    private String endTime;
}
