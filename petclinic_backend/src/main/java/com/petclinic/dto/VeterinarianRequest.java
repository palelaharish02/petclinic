package com.petclinic.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class VeterinarianRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Specialty is required")
    private String specialty;

    private boolean available;
}
