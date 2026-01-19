package com.petclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VeterinarianResponse {

    private Long id;
    private String name;
    private String email;
    private String specialty;
    private boolean available;
}
