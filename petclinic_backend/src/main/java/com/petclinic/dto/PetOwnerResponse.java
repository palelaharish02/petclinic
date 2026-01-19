package com.petclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PetOwnerResponse {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
}
