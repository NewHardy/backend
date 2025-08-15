package com.example.FirstSpringBoot.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class Pokemon {
    @Id
    private Long id;
    private String image;
    private String name;
    private ArrayList<String> types;
    private String evoFrom;
    private String hp;
    private String attack;
    private String height;
    private String specialAttack;
    private String speed;
    private String nextEvo;

    public String getAbility() {
        return Ability;
    }

    public void setAbility(String ability) {
        Ability = ability;
    }

    public String getNextEvo() {
        return nextEvo;
    }

    public void setNextEvo(String nextEvo) {
        this.nextEvo = nextEvo;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(String specialAttack) {
        this.specialAttack = specialAttack;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    private String Ability;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public ArrayList<String> getTypes() { return types; }
    public void setTypes(ArrayList<String> types) { this.types = types; }

    public String getEvoFrom() { return evoFrom; }
    public void setEvoFrom(String evoFrom) { this.evoFrom = evoFrom; }
}
