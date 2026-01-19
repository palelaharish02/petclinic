package com.petclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PetResponse {

    private Long id;
    private String name;
    private String breed;
    private int age;
    private String medicalHistory;
    private String imageUrl;
    private String vaccinationSchedule;
    private Long ownerId;
}
