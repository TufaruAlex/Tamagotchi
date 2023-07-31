package com.example.tamagotchi.service;

import com.example.tamagotchi.model.Pet;
import com.example.tamagotchi.repo.PetRepo;

@org.springframework.stereotype.Service
public class Service {
    private final PetRepo petRepo;

    public Service(PetRepo petRepo) {
        this.petRepo = petRepo;
    }

    public void playWithPet(Integer petId) {
        Pet pet = petRepo.getReferenceById(petId);
        pet.setHappiness(pet.getHappiness() + 10);
        pet.setHappiness(Math.min(pet.getHappiness(), 100));
        petRepo.save(pet);
    }

    public void feedPet(Integer petId) {
        Pet pet = petRepo.getReferenceById(petId);
        pet.setHealth(pet.getHealth() + 10);
        pet.setHealth(Math.max(0, pet.getHealth()));
        petRepo.save(pet);
    }

    public void cleanPet(Integer petId) {
        Pet pet = petRepo.getReferenceById(petId);
        pet.setCleanliness(pet.getCleanliness() + 10);
        pet.setCleanliness(Math.min(pet.getCleanliness(), 100));
        petRepo.save(pet);
    }

    public void agePet(Integer petId) {
        Pet pet = petRepo.getReferenceById(petId);
        pet.setAge(pet.getAge() + 1);
        petRepo.save(pet);
    }

    public void decreaseHealth(Integer petId) {
        Pet pet = petRepo.getReferenceById(petId);
        pet.setHealth(pet.getHealth() - 1);
        pet.setHealth(Math.max(0, pet.getHealth()));
        petRepo.save(pet);
    }

    public void decreaseHappiness(Integer petId) {
        Pet pet = petRepo.getReferenceById(petId);
        pet.setHappiness(pet.getHappiness() - 1);
        pet.setHappiness(Math.max(0, pet.getHappiness()));
        petRepo.save(pet);
    }

    public void decreaseCleanliness(Integer petId) {
        Pet pet = petRepo.getReferenceById(petId);
        pet.setCleanliness(pet.getCleanliness() - 1);
        pet.setCleanliness(Math.max(0, pet.getCleanliness()));
        petRepo.save(pet);
    }
}
