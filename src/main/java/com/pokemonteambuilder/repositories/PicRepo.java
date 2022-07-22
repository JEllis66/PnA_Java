package com.pokemonteambuilder.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pokemonteambuilder.models.Picture;

@Repository
public interface PicRepo extends CrudRepository<Picture, Long>{

}
