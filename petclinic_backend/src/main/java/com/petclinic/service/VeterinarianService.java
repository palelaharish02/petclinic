package com.petclinic.service;

import com.petclinic.dto.*;
import com.petclinic.entity.Veterinarian;
import com.petclinic.exception.ResourceNotFoundException;
import com.petclinic.repository.VeterinarianRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeterinarianService {

    private final VeterinarianRepository veterinarianRepository;

    // ADD VET
    public VeterinarianResponse createVet(VeterinarianRequest request) {

        Veterinarian vet = new Veterinarian();
        vet.setName(request.getName());
        vet.setEmail(request.getEmail());
        vet.setSpecialty(request.getSpecialty());
        vet.setAvailable(request.isAvailable());

        return mapToResponse(veterinarianRepository.save(vet));
    }

    // GET ALL VETS
    public List<VeterinarianResponse> getAllVets() {
        return veterinarianRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // UPDATE VET
    public VeterinarianResponse updateVet(
            Long id, VeterinarianRequest request) {

        Veterinarian vet = veterinarianRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vet not found"));

        vet.setName(request.getName());
        vet.setEmail(request.getEmail());
        vet.setSpecialty(request.getSpecialty());
        vet.setAvailable(request.isAvailable());

        return mapToResponse(veterinarianRepository.save(vet));
    }

    // DELETE VET
    public void deleteVet(Long id) {

        Veterinarian vet = veterinarianRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vet not found"));

        veterinarianRepository.delete(vet);
    }

    // GET AVAILABLE VETS
    public List<VeterinarianResponse> getAvailableVets() {
        return veterinarianRepository.findByAvailableTrue()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // SEARCH BY SPECIALTY
    public List<VeterinarianResponse> getBySpecialty(String specialty) {
        return veterinarianRepository
                .findBySpecialtyIgnoreCase(specialty)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // VET DASHBOARD (BY EMAIL)
    public VetDashboardResponse getVetDashboard(String email) {

        Veterinarian vet = veterinarianRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vet not found"));

        return new VetDashboardResponse(
                vet.getName(),
                vet.getSpecialty(),
                vet.isAvailable(),
                "Welcome to Veterinarian Dashboard"
        );
    }

    // MAPPER
    private VeterinarianResponse mapToResponse(Veterinarian vet) {
        return new VeterinarianResponse(
                vet.getId(),
                vet.getName(),
                vet.getEmail(),
                vet.getSpecialty(),
                vet.isAvailable()
        );
    }
}
