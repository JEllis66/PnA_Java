package com.pokemonteambuilder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemonteambuilder.models.Picture;
import com.pokemonteambuilder.models.User;
import com.pokemonteambuilder.repositories.PicRepo;
import com.pokemonteambuilder.repositories.UserRepository;

@Service
public class PicServ {
	@Autowired
	PicRepo picRepo;
	@Autowired
	UserRepository userRepo;
	
	public void addProPic(String url, User user) {
		if (user.getProfilePic() == null) {
			Picture newPic = new Picture(url, user);
			picRepo.save(newPic);
		}
		else {
			Picture newPic = user.getProfilePic();
			newPic.setUrl(url);
			user.setProfilePic(newPic);
			userRepo.save(user);
		}
	}
}
