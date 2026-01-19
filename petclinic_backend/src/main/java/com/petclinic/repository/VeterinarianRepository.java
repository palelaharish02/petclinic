package com.petclinic.repository;

import com.petclinic.entity.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VeterinarianRepository
        extends JpaRepository<Veterinarian, Long> {

    List<Veterinarian> findBySpecialtyIgnoreCase(String specialty);

    List<Veterinarian> findByAvailableTrue();

    Optional<Veterinarian> findByEmail(String email);
}
