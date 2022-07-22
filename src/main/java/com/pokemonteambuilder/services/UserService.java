package com.pokemonteambuilder.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.pokemonteambuilder.repositories.UserRepository;
import com.pokemonteambuilder.models.LoginUser;
import com.pokemonteambuilder.models.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
		
	//Create
	
    public User register(User newUser, BindingResult result) {
        
		Optional<User> userLookUp = userRepository.findByEmail(newUser.getEmail());
		
		if (userLookUp.isPresent()) {
			result.rejectValue("email", "Unique", "Email address is already in use.");
		} 
		
		if (!(newUser.getPassword().equals(newUser.getConfirmation()))) {
			result.rejectValue("confirmation", "Matches", "Passwords do not match.");
		}
		
		if (result.hasErrors()) {
			return null;
		}
		
		String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashedPassword);
		
		newUser = userRepository.save(newUser);
		return newUser;
	
    }
	
    
//Read
	
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
    
    public User findById(Long id) {
        Optional<User> optionalUserId = userRepository.findById(id);
        if(optionalUserId.isPresent()) {
            return optionalUserId.get();
        }
        return null;
    }
    
    public User login(LoginUser newLogin, BindingResult result) {
    	
    	Optional<User> userLookUp = userRepository.findByEmail(newLogin.getEmail());
    	if(!(userLookUp.isPresent())) {
    		result.rejectValue("email", "MissingAccount", "This user was not found.");
    		return null;
    	}
    	
    	User user = userLookUp.get();
    	if(!(BCrypt.checkpw(newLogin.getPassword(), user.getPassword()))) {
    		result.rejectValue("password", "Matches", "Password and email combination does not match.");
    	}
    	
    	if(result.hasErrors()) {
    		return null;
    	}
    	
    	return user;
    	
    }
    
    public User findByEmail(String email){
    	
    	Optional<User> optionalUserEmail = userRepository.findByEmail(email);
    	if(optionalUserEmail.isPresent()) {
    		return optionalUserEmail.get();
    	}
    	return null;
    	
    }
	
	
}
