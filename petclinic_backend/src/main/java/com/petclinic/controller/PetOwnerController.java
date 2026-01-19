package com.petclinic.controller;

import com.petclinic.dto.*;
import com.petclinic.service.PetOwnerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/owners")
@RequiredArgsConstructor
public class PetOwnerController {

    private final PetOwnerService petOwnerService;

    // CREATE OWNER
    @PostMapping
    public PetOwnerResponse createOwner(
            @Valid @RequestBody PetOwnerRequest request) {
        return petOwnerService.createOwner(request);
    }

    // GET ALL OWNERS
    @GetMapping
    public List<PetOwnerResponse> getAllOwners() {
        return petOwnerService.getAllOwners();
    }

    // GET OWNER BY ID
    @GetMapping("/{id}")
    public PetOwnerResponse getOwnerById(@PathVariable Long id) {
        return petOwnerService.getOwnerById(id);
    }

    // UPDATE OWNER
    @PutMapping("/{id}")
    public PetOwnerResponse updateOwner(
            @PathVariable Long id,
            @Valid @RequestBody PetOwnerRequest request) {
        return petOwnerService.updateOwner(id, request);
    }

    // DELETE OWNER
    @DeleteMapping("/{id}")
    public String deleteOwner(@PathVariable Long id) {
        petOwnerService.deleteOwner(id);
        return "Owner deleted successfully";
    }

    // SEARCH BY NAME
    @GetMapping("/search/name")
    public List<PetOwnerResponse> searchByName(
            @RequestParam String name) {
        return petOwnerService.searchByName(name);
    }

    // SEARCH BY EMAIL
    @GetMapping("/search/email")
    public List<PetOwnerResponse> searchByEmail(
            @RequestParam String email) {
        return petOwnerService.searchByEmail(email);
    }

    // OWNER DASHBOARD
    @GetMapping("/{id}/dashboard")
    public OwnerDashboardResponse getOwnerDashboard(
            @PathVariable Long id) {
        return petOwnerService.getOwnerDashboard(id);
    }

    // AI HEALTH SUGGESTION (PROTOTYPE)
    @GetMapping("/{id}/health-suggestion")
    public HealthSuggestionResponse getHealthSuggestion(
            @PathVariable Long id) {
        return petOwnerService.getHealthSuggestion(id);
    }
}
