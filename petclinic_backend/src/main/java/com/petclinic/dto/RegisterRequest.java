package com.petclinic.dto;

import com.petclinic.entity.Role;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;

    @Size(min = 5, message = "Password must be at least 5 characters")
    private String password;

    @NotNull(message = "Role is required")
    private Role role;
}
