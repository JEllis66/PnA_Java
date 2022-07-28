package com.pokemonteambuilder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemonteambuilder.models.Pokemon;
import com.pokemonteambuilder.models.Team;
import com.pokemonteambuilder.repositories.PokemonRepo;

@Service
public class PokemonService {
	@Autowired
	PokemonRepo pokeRepo;
	
	public Pokemon createPokemon(Pokemon poke, Team team) {
		if(team.getPokemon().size()<=6) {
		return pokeRepo.save(poke);
		}
		return null;
	}
	public Pokemon updatePokemon(Pokemon pokemon) {
		return pokeRepo.save(pokemon);
	}
	
	public void deletePokemon(Pokemon pokemon) {
		pokeRepo.delete(pokemon);
	}
	public Pokemon findPokemon(Long id) {
		return pokeRepo.findById(id).get();
	}

} 
