package com.pokemonteambuilder.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pokemonteambuilder.models.Pokemon;

@Repository
public interface PokemonRepo extends CrudRepository<Pokemon, Long> {

}
