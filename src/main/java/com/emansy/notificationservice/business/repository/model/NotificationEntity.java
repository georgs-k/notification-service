package com.emansy.notificationservice.business.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notification")
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "time_stamp")
    private LocalDateTime timeStamp;

    @Column(name = "attend_or_unattend")
    private Boolean attendOrUnattend;

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "event_id")
    private Long eventId;
}
