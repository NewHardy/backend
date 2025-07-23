package com.example.FirstSpringBoot.controller;

import com.example.FirstSpringBoot.entity.Pokemon;
import com.example.FirstSpringBoot.repository.PokemonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
@CrossOrigin("*")
public class PokemonController {
    private final PokemonRepository repository;

    public PokemonController(PokemonRepository repository) {
        this.repository = repository;
    }
    @GetMapping
    public List<Pokemon> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Pokemon save(@RequestBody Pokemon pokemon) {
        return repository.save(pokemon);
    }
}