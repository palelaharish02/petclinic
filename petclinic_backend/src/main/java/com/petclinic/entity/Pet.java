package com.petclinic.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String breed;

    private int age;

    @Column(length = 1000)
    private String medicalHistory;

    // Image stored as filename (simple approach)
    private String imageUrl;

    // Vaccination info (simple text)
    private String vaccinationSchedule;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private PetOwner owner;
}
