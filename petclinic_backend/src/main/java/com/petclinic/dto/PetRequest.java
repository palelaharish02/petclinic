package com.petclinic.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PetRequest {

    @NotBlank(message = "Pet name is required")
    private String name;

    @NotBlank(message = "Breed is required")
    private String breed;

    @Min(value = 0, message = "Age must be positive")
    private int age;

    private String medicalHistory;

    private String vaccinationSchedule;
}
