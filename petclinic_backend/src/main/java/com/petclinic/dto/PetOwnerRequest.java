package com.petclinic.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PetOwnerRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Phone is required")
    private String phone;

    @NotBlank(message = "Address is required")
    private String address;
}
