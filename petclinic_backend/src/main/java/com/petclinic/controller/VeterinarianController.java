package com.petclinic.controller;

import com.petclinic.dto.*;
import com.petclinic.service.VeterinarianService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VeterinarianController {

    private final VeterinarianService veterinarianService;

    // ADMIN – ADD VET
    @PostMapping("/api/admin/vets")
    public VeterinarianResponse createVet(
            @Valid @RequestBody VeterinarianRequest request) {

        return veterinarianService.createVet(request);
    }

    // ADMIN – GET ALL VETS
    @GetMapping("/api/admin/vets")
    public List<VeterinarianResponse> getAllVets() {
        return veterinarianService.getAllVets();
    }

    // ADMIN – UPDATE VET
    @PutMapping("/api/admin/vets/{id}")
    public VeterinarianResponse updateVet(
            @PathVariable Long id,
            @Valid @RequestBody VeterinarianRequest request) {

        return veterinarianService.updateVet(id, request);
    }

    // ADMIN – DELETE VET
    @DeleteMapping("/api/admin/vets/{id}")
    public String deleteVet(@PathVariable Long id) {
        veterinarianService.deleteVet(id);
        return "Veterinarian deleted successfully";
    }

    // ADMIN – AVAILABLE VETS
    @GetMapping("/api/admin/vets/available")
    public List<VeterinarianResponse> getAvailableVets() {
        return veterinarianService.getAvailableVets();
    }

    // ADMIN – SEARCH BY SPECIALTY
    @GetMapping("/api/admin/vets/specialty")
    public List<VeterinarianResponse> getBySpecialty(
            @RequestParam String specialty) {

        return veterinarianService.getBySpecialty(specialty);
    }

    // VET – DASHBOARD
    @GetMapping("/api/vet/dashboard")
    public VetDashboardResponse vetDashboard() {

        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return veterinarianService.getVetDashboard(email);
    }
}
