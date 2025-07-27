package com.example.FirstSpringBoot.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String name;
    private ArrayList<String> types;
    private String evoFrom;

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
