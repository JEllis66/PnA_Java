package com.pokemonteambuilder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.pokemonteambuilder.models.Pokemon;
import com.pokemonteambuilder.models.Team;
import com.pokemonteambuilder.repositories.TeamRepository;

@Service
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private PokemonService pokemonService;
	
	//Create
	
		public Team createTeam(Team t) {
			return teamRepository.save(t);
		}
		
		public Team addPokemonToTeam(Long teamId, Long pokemonId) {
			Team team = findById(teamId);
			team.getPokemon().add(pokemonService.findPokemon(pokemonId));
			teamRepository.save(team);
			return team;
		}
		
		public Team removePokemonFromTeam(Long teamId, Long pokemonId) {
			Team team = findById(teamId);
			team.getPokemon().remove(pokemonService.findPokemon(pokemonId));
			teamRepository.save(team);
			return team;
		}
	
	
	//Read
	
		public List<Team> allTeams() {
			return teamRepository.findAll();
		}

		public Team findById(Long id) {
			Optional<Team> optionalTeam = teamRepository.findById(id);
			if(optionalTeam.isPresent()) {
				return optionalTeam.get();
			}
			return null;
		}
		
		
	//Update
		
		public Team updateTeam(Team t) {
			return teamRepository.save(t);
		}
		
	//Delete
		
		public void deleteTeam(Long id) {
			teamRepository.delete(findById(id));
		}
	
	//checks the number of pokemons in a team
	
		public Team teamLimitChecker(Long teamId, BindingResult result) {
			List<Pokemon> pokemons = findById(teamId).getPokemon();
			if (pokemons.size() >= 6) {
				result.rejectValue("pokemons", "Matches", "Too many pokemon in this Team!");
	    		return null;
			}
			return null;
		}
	
}
