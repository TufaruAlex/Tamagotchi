package com.example.tamagotchi.controller;

import com.example.tamagotchi.service.Service;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/play")
public class PetController {
    private final Service service;

    public PetController(Service service) {
        this.service = service;
    }

    @PostMapping("/feed")
    public ResponseEntity<String> feedPet(@RequestParam Integer petId) {
        try {
            service.feedPet(petId);
            return ResponseEntity.ok("Pet fed successfully.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet not found.");
        }
    }

    @PostMapping("/play")
    public ResponseEntity<String> playWithPet(@RequestParam Integer petId) {
        try {
            service.playWithPet(petId);
            return ResponseEntity.ok("Pet played with successfully.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet not found.");
        }
    }

    @PostMapping("/clean")
    public ResponseEntity<String> cleanPet(@RequestParam Integer petId) {
        try {
            service.cleanPet(petId);
            return ResponseEntity.ok("Pet cleaned successfully.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet not found.");
        }
    }

    @PostMapping("/decrease")
    public ResponseEntity<String> decreaseAttributes(@RequestParam Integer petId) {
        try {
            service.decreaseHealth(petId);
            service.decreaseCleanliness(petId);
            service.decreaseHappiness(petId);
            return ResponseEntity.ok("Attributes decreased.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet not found.");
        }
    }

    @PostMapping("/age")
    public ResponseEntity<String> agePet(@RequestParam Integer petId) {
        try {
            service.agePet(petId);
            return ResponseEntity.ok("Pet aged successfully.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet not found.");
        }
    }
}
