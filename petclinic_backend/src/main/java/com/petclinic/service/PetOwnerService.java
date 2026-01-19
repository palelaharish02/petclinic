package com.petclinic.service;

import com.petclinic.dto.*;
import com.petclinic.entity.PetOwner;
import com.petclinic.exception.ResourceNotFoundException;
import com.petclinic.repository.PetOwnerRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetOwnerService {

    private final PetOwnerRepository petOwnerRepository;

    // CREATE OWNER
    public PetOwnerResponse createOwner(PetOwnerRequest request) {

        PetOwner owner = new PetOwner();
        owner.setName(request.getName());
        owner.setEmail(request.getEmail());
        owner.setPhone(request.getPhone());
        owner.setAddress(request.getAddress());

        return mapToResponse(petOwnerRepository.save(owner));
    }

    // GET ALL OWNERS
    public List<PetOwnerResponse> getAllOwners() {
        return petOwnerRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // GET OWNER BY ID
    public PetOwnerResponse getOwnerById(Long id) {

        PetOwner owner = petOwnerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Owner not found"));

        return mapToResponse(owner);
    }

    // UPDATE OWNER
    public PetOwnerResponse updateOwner(Long id, PetOwnerRequest request) {

        PetOwner owner = petOwnerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Owner not found"));

        owner.setName(request.getName());
        owner.setEmail(request.getEmail());
        owner.setPhone(request.getPhone());
        owner.setAddress(request.getAddress());

        return mapToResponse(petOwnerRepository.save(owner));
    }

    // DELETE OWNER
    public void deleteOwner(Long id) {

        PetOwner owner = petOwnerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Owner not found"));

        petOwnerRepository.delete(owner);
    }

    // SEARCH BY NAME
    public List<PetOwnerResponse> searchByName(String name) {
        return petOwnerRepository
                .findByNameContainingIgnoreCase(name)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // SEARCH BY EMAIL
    public List<PetOwnerResponse> searchByEmail(String email) {
        return petOwnerRepository
                .findByEmailContainingIgnoreCase(email)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // OWNER DASHBOARD
    public OwnerDashboardResponse getOwnerDashboard(Long ownerId) {

        PetOwner owner = petOwnerRepository.findById(ownerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Owner not found"));

        return new OwnerDashboardResponse(
                owner.getId(),
                owner.getName(),
                owner.getEmail(),
                owner.getPhone(),
                owner.getAddress(),
                "Welcome to your Pet Owner Dashboard"
        );
    }

    // AI HEALTH SUGGESTION (PROTOTYPE)
    public HealthSuggestionResponse getHealthSuggestion(Long ownerId) {

        PetOwner owner = petOwnerRepository.findById(ownerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Owner not found"));

        String suggestion =
                "Ensure regular vaccinations, balanced diet, clean water, and annual vet checkups for your pets.";

        return new HealthSuggestionResponse(owner.getId(), suggestion);
    }

    // MAPPER
    private PetOwnerResponse mapToResponse(PetOwner owner) {
        return new PetOwnerResponse(
                owner.getId(),
                owner.getName(),
                owner.getEmail(),
                owner.getPhone(),
                owner.getAddress()
        );
    }
}
