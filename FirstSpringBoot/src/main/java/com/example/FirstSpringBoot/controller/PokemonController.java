package com.example.FirstSpringBoot.controller;

import com.example.FirstSpringBoot.entity.User;
import com.example.FirstSpringBoot.service.PokemonService;
import com.example.FirstSpringBoot.entity.Pokemon;
import com.example.FirstSpringBoot.repository.PokemonRepository;
import com.example.FirstSpringBoot.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pokemons")
@CrossOrigin("*")
public class PokemonController {
    private final PokemonService service;
    public PokemonController(PokemonService service)
    {
        this.service = service;
    }
    @GetMapping
    public List<Pokemon> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<Pokemon> create(@RequestBody Pokemon pokemon) throws URISyntaxException {
        return service.create(pokemon);
    }

    @DeleteMapping("/{index}/")
    public ResponseEntity<Void> delete (@PathVariable Long index) {
        return service.delete(index);
    }

    @GetMapping("/{index}/")
    public Optional<Pokemon> getById(@PathVariable Long index)
    {
        return service.getPokemonById(index);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll()
    {
     return service.deleteAll();
    }
}