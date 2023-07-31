package com.example.tamagotchi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false, unique = true)
    private String playerName;
    @Column(nullable = false)
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id", referencedColumnName = "id")
    private Pet pet;

    public Player(String playerName, String password) {
        this.playerName = playerName;
        this.password = password;
        this.pet = new Pet();
    }
}
