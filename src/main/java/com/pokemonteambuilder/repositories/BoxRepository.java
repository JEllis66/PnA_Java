package com.pokemonteambuilder.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pokemonteambuilder.models.Box;

@Repository
public interface BoxRepository extends CrudRepository<Box, Long> {

	List<Box> findAll();

	
	
}
