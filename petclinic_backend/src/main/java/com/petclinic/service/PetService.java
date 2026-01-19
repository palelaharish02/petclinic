package com.petclinic.service;

import com.petclinic.dto.*;
import com.petclinic.entity.Pet;
import com.petclinic.entity.PetOwner;
import com.petclinic.exception.ResourceNotFoundException;
import com.petclinic.repository.PetOwnerRepository;
import com.petclinic.repository.PetRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;
    private final PetOwnerRepository petOwnerRepository;

    // ADD PET TO OWNER
    public PetResponse addPet(Long ownerId, PetRequest request) {

        PetOwner owner = petOwnerRepository.findById(ownerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Owner not found"));

        Pet pet = new Pet();
        pet.setName(request.getName());
        pet.setBreed(request.getBreed());
        pet.setAge(request.getAge());
        pet.setMedicalHistory(request.getMedicalHistory());
        pet.setVaccinationSchedule(request.getVaccinationSchedule());
        pet.setOwner(owner);

        return mapToResponse(petRepository.save(pet));
    }

    // GET ALL PETS OF OWNER
    public List<PetResponse> getPetsByOwner(Long ownerId) {
        return petRepository.findByOwnerId(ownerId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // GET PET BY ID
    public PetResponse getPetById(Long petId) {

        Pet pet = petRepository.findById(petId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Pet not found"));

        return mapToResponse(pet);
    }

    // UPDATE PET
    public PetResponse updatePet(Long petId, PetRequest request) {

        Pet pet = petRepository.findById(petId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Pet not found"));

        pet.setName(request.getName());
        pet.setBreed(request.getBreed());
        pet.setAge(request.getAge());
        pet.setMedicalHistory(request.getMedicalHistory());
        pet.setVaccinationSchedule(request.getVaccinationSchedule());

        return mapToResponse(petRepository.save(pet));
    }

    // DELETE PET
    public void deletePet(Long petId) {

        Pet pet = petRepository.findById(petId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Pet not found"));

        petRepository.delete(pet);
    }

    // MAP RESPONSE
    private PetResponse mapToResponse(Pet pet) {
        return new PetResponse(
                pet.getId(),
                pet.getName(),
                pet.getBreed(),
                pet.getAge(),
                pet.getMedicalHistory(),
                pet.getImageUrl(),
                pet.getVaccinationSchedule(),
                pet.getOwner().getId()
        );
    }
}
