package com.pokemonteambuilder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemonteambuilder.models.Discussion;
import com.pokemonteambuilder.repositories.DiscussionRepository;


@Service
public class DiscussionService {

	@Autowired
	private DiscussionRepository discussionRepository;
	
	
	//Create
	
		public Discussion createDiscussion(Discussion d) {
			return discussionRepository.save(d);
		}
	
	
	//Read
	
		public List<Discussion> allDiscussions() {
			return discussionRepository.findAll();
		}

		public Discussion findById(Long id) {
			Optional<Discussion> optionalShowId = discussionRepository.findById(id);
			if(optionalShowId.isPresent()) {
				return optionalShowId.get();
			}
			return null;
		}
		
		
	//Update
		
		public Discussion updateDiscussion(Discussion d) {
			return discussionRepository.save(d);
		}
		
	//Delete
		
		public void deleteDiscussion(Long id) {
			discussionRepository.delete(findById(id));
		}
	
}
