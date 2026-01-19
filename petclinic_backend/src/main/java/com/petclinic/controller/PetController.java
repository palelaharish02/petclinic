package com.petclinic.controller;

import com.petclinic.dto.*;
import com.petclinic.service.PetService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    // ADD PET TO OWNER
    @PostMapping("/owner/{ownerId}")
    public PetResponse addPet(
            @PathVariable Long ownerId,
            @Valid @RequestBody PetRequest request) {

        return petService.addPet(ownerId, request);
    }

    // GET ALL PETS OF OWNER
    @GetMapping("/owner/{ownerId}")
    public List<PetResponse> getPetsByOwner(
            @PathVariable Long ownerId) {

        return petService.getPetsByOwner(ownerId);
    }

    // GET PET BY ID
    @GetMapping("/{petId}")
    public PetResponse getPetById(@PathVariable Long petId) {
        return petService.getPetById(petId);
    }

    // UPDATE PET
    @PutMapping("/{petId}")
    public PetResponse updatePet(
            @PathVariable Long petId,
            @Valid @RequestBody PetRequest request) {

        return petService.updatePet(petId, request);
    }

    // DELETE PET
    @DeleteMapping("/{petId}")
    public String deletePet(@PathVariable Long petId) {
        petService.deletePet(petId);
        return "Pet deleted successfully";
    }
}
