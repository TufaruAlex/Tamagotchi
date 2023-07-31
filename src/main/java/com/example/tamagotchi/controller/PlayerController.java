package com.example.tamagotchi.controller;

import com.example.tamagotchi.dto.PlayerRequest;
import com.example.tamagotchi.model.Player;
import com.example.tamagotchi.repo.PlayerRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/home")
public class PlayerController {
    private final PlayerRepo playerRepo;

    public PlayerController(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerNewPlayer(@RequestBody PlayerRequest request) {
        if (playerRepo.findByPlayerName(request.getName()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Player name already exists.");
        }
        Player newPlayer = new Player(request.getName(), request.getPassword());
        playerRepo.save(newPlayer);
        return ResponseEntity.ok("Player registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody PlayerRequest request) {
        Player player = playerRepo.findByPlayerName(request.getName());
        if (player == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid player name.");
        }
        if (!Objects.equals(request.getPassword(), player.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password.");
        }
        return ResponseEntity.ok("Player logged in successfully!");
    }
}
