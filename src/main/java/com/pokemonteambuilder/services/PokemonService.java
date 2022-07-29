package com.pokemonteambuilder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemonteambuilder.models.Pokemon;
import com.pokemonteambuilder.models.Team;
import com.pokemonteambuilder.repositories.PokemonRepo;
import com.pokemonteambuilder.repositories.TeamRepository;

@Service
public class PokemonService {
	@Autowired
	PokemonRepo pokeRepo;
	@Autowired
	TeamRepository teamRepo;
	
	public Pokemon createPokemon(Pokemon poke, Long id) {
		Team team = teamRepo.findById(id).get();
		poke.setPokemonTeam(team);

			return pokeRepo.save(poke);
		
	
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
