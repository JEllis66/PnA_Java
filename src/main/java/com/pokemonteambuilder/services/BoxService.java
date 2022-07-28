package com.pokemonteambuilder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.pokemonteambuilder.models.Box;
import com.pokemonteambuilder.models.User;
import com.pokemonteambuilder.models.Team;
import com.pokemonteambuilder.repositories.BoxRepository;

@Service
public class BoxService {

	@Autowired
	private BoxRepository boxRepository;
	
	
	//Create
	
		public Box createBox(Box b, User u) {
			b.setTitle("Box " + u.getBoxes().size());
			b.setUser(u);
			return boxRepository.save(b);
		}
	
	
	//Read
	
		public List<Box> allBoxes() {
			return boxRepository.findAll();
		}

		public Box findById(Long id) {
			Optional<Box> optionalShowId = boxRepository.findById(id);
			if(optionalShowId.isPresent()) {
				return optionalShowId.get();
			}
			return null;
		}
		
		
	//Update
		
		public Box updateBox(Box b) {
			return boxRepository.save(b);
		}
		
	//Delete
		
		public void deleteBox(Long id) {
			boxRepository.delete(findById(id));
		}
		
	//checks the number of teams in a box
		
		public Box boxLimitChecker(Long boxId, BindingResult result) {
			List <Team> teams= findById(boxId).getTeams();
			if (teams.size() < 5) {
				result.rejectValue("teams", "Matches", "Too many teams in this Box!");
	    		return null;
			}
			return null;
		}
}
