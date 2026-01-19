package com.petclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VetDashboardResponse {

    private String vetName;
    private String specialty;
    private boolean available;
    private String message;
}
