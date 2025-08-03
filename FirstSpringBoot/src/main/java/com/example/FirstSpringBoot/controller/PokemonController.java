package com.example.FirstSpringBoot.controller;

import com.example.FirstSpringBoot.service.PokemonService;
import com.example.FirstSpringBoot.entity.Pokemon;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public ResponseEntity<Pokemon> create(@RequestBody Pokemon pokemon){
        return service.create(pokemon);
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<Void> delete (@PathVariable Long index) {
        return service.delete(index);
    }

    @GetMapping("/{index}")
    public ResponseEntity<Object> getById(@PathVariable Long index)
    {
        return service.getPokemonById(index);
    }
    @GetMapping("/{offset}/")
    public ResponseEntity<Object> getFromOffset(@PathVariable Long offset)
    {
        return service.getFromOffset(offset);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll()
    {
     return service.deleteAll();
    }
}