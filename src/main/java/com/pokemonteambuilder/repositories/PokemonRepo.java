package com.pokemonteambuilder.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pokemonteambuilder.models.Pokemon;

@Repository
public interface PokemonRepo extends CrudRepository<Pokemon, Long> {
	
	List<Pokemon> findAll();
	
	Pokemon findByName(String name);
	
	Optional<Pokemon> findById(Long id);

}
