package com.petclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HealthSuggestionResponse {

    private Long ownerId;
    private String suggestion;
}
