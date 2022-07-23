package com.pokemonteambuilder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemonteambuilder.models.Box;
import com.pokemonteambuilder.repositories.BoxRepository;

@Service
public class BoxService {

	@Autowired
	private BoxRepository boxRepository;
	
	
	//Create
	
		public Box createBox(Box b) {
			b.setTitle("Box" + b.getId());
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
	
}
