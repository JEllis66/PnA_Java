package com.pokemonteambuilder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.pokemonteambuilder.models.Pokemon;
import com.pokemonteambuilder.repositories.PokemonRepository;

public class PokemonService {
	
	@Autowired
	private PokemonRepository pokemonRepository;

	public Pokemon findById(Long id) {
		Optional<Pokemon> optionalPokemon = pokemonRepository.findById(id);
		if(optionalPokemon.isPresent()) {
			return optionalPokemon.get();
		}
		return null;
	}
	
	public List<Pokemon> allPokemons() {
		return pokemonRepository.findAll();
	}
}
