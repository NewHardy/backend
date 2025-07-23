package com.example.FirstSpringBoot.repository;

import com.example.FirstSpringBoot.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository <Pokemon, Long> {

}
