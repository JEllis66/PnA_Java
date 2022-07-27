package com.pokemonteambuilder.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pokemonteambuilder.models.Discussion;

@Repository
public interface DiscussionRepository extends CrudRepository<Discussion, Long> {
	
	Page<Discussion> findAll(Pageable pageable);

}
