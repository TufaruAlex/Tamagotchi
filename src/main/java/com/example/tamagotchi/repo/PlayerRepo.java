package com.example.tamagotchi.repo;

import com.example.tamagotchi.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepo extends JpaRepository<Player, Integer> {
}
