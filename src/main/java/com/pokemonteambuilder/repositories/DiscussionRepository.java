package com.pokemonteambuilder.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pokemonteambuilder.models.Discussion;

@Repository
public interface DiscussionRepository extends CrudRepository<Discussion, Long> {
	
	List<Discussion> findAll();

}
