package com.emansy.notificationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class OfficeDto {

    private Long id;

    private String name;

    private String streetAddress;

    private String city;

    private CountryDto countryDto;
}
