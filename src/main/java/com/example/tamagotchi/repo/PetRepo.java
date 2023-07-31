package com.example.tamagotchi.repo;

import com.example.tamagotchi.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepo extends JpaRepository<Pet, Integer> {
}
