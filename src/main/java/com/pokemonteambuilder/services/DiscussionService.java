package com.pokemonteambuilder.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	
		public Page<Discussion> getDiscussionPage(int page, int size) {
			Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
			return discussionRepository.findAll(pageable);
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
