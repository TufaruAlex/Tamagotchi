package com.example.tamagotchi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer health;
    private Integer happiness;
    private Integer cleanliness;
    private Integer age;
    @OneToOne(mappedBy = "pet")
    private Player player;

    public Pet() {
        this.health = 100;
        this.happiness = 100;
        this.cleanliness = 100;
        this.age = 0;
    }
}
