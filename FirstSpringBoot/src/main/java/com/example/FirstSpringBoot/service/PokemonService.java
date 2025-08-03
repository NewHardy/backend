package com.example.FirstSpringBoot.service;

import com.example.FirstSpringBoot.entity.Pokemon;
import com.example.FirstSpringBoot.repository.PokemonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PokemonService
{
    private final PokemonRepository repo;
    public PokemonService(PokemonRepository repo)
    {
        this.repo=repo;
    }

    public List<Pokemon> getAll()
    {
        return repo.findAll();
    }

    public ResponseEntity<Pokemon> create (@RequestBody Pokemon pokemon){
        Pokemon createdPokemon = repo.save(pokemon);
        return new ResponseEntity<>(createdPokemon, HttpStatus.CREATED);
    }
    public ResponseEntity<Void> delete (Long index)
    {
        if(repo.existsById(index))
        {
            repo.deleteById(index);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    public ResponseEntity<Object> getPokemonById(Long id)
    {
        Optional<Pokemon> pokemon = repo.findById(id);
        if (pokemon.isPresent())
        {
            return new ResponseEntity<>(pokemon.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(Collections.emptyMap(),HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Object> getFromOffset(Long offset)
    {
        // TODO: make function to get only 21 pokemons from offset
        ArrayList<Pokemon> pokemonList= new ArrayList<>();
        for (int i = 1; i <= 21; i++) {
            pokemonList.add((Pokemon) getPokemonById(offset+i).getBody());
        }
        return new ResponseEntity<>(pokemonList, HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteAll()
    {
        repo.deleteAll();
        return ResponseEntity.noContent().build();
    }
}

