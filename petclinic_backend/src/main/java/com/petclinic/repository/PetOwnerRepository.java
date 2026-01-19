package com.petclinic.repository;

import com.petclinic.entity.PetOwner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetOwnerRepository extends JpaRepository<PetOwner, Long> {

    List<PetOwner> findByNameContainingIgnoreCase(String name);

    List<PetOwner> findByEmailContainingIgnoreCase(String email);
}
