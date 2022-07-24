package com.pokemonteambuilder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemonteambuilder.models.Team;
import com.pokemonteambuilder.repositories.TeamRepository;

@Service
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;
	
	
	//Create
	
		public Team createTeam(Team t) {
			return teamRepository.save(t);
		}
	
	
	//Read
	
		public List<Team> allTeams() {
			return teamRepository.findAll();
		}

		public Team findById(Long id) {
			Optional<Team> optionalShowId = teamRepository.findById(id);
			if(optionalShowId.isPresent()) {
				return optionalShowId.get();
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
	
	//checks the number of teams in a box
		public boolean limitCheck(Long boxId) {
			List <Team> teams= teamRepository.findByBoxId(boxId);
			if (teams.size() > 5) {
				return false;
			}
			return true;
		}
	
}
