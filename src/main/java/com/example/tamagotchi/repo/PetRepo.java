package com.example.tamagotchi.repo;

import com.example.tamagotchi.model.Pet;
import com.example.tamagotchi.service.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PetRepo extends JpaRepository<Pet, Integer> {
}
