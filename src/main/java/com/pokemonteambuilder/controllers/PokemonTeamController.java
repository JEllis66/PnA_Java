package com.pokemonteambuilder.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pokemonteambuilder.models.LoginUser;
import com.pokemonteambuilder.models.Pokemon;
import com.pokemonteambuilder.models.User;
import com.pokemonteambuilder.models.Box;
import com.pokemonteambuilder.models.Team;
import com.pokemonteambuilder.models.Discussion;

import com.pokemonteambuilder.services.TeamService;
import com.pokemonteambuilder.services.UserService;

@Controller
public class PokemonTeamController {

	@Autowired
	TeamService teamService;
	@Autowired
	UserService userService;
	
	
	//index
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}
	
	//Create
	
	@PostMapping("/createUser")
	public String registerUser(Model model, @Valid @ModelAttribute("newUser") User newUser, BindingResult result, HttpSession session) {
		User user = userService.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		session.setAttribute("userName", user.getName());
		session.setAttribute("userId", user.getId());
		return "redirect:/dashboard"; //homepage for user "Hello User"
	}
	
	@PostMapping("/discussion/submit")
	public String addNewDiscussion(@Valid @ModelAttribute("discussion") Discussion discussion, BindingResult result){
			
		if (result.hasErrors()) {
			return "newDiscussion.jsp";
		}
		discussionService.createDiscussion(discussion);
		return "redirect:/discussion";
	}
	
	@PostMapping("/team/submit")
	public String addNewTeam(@Valid @ModelAttribute("tvshow") Team team, BindingResult result){
			
		if (result.hasErrors()) {
			return "newTeam.jsp";
		}
		teamService.createTeam(team);
		return "redirect:/teams";
	}
	
	@PostMapping("/box/submit")
	public String addNewBox(@Valid @ModelAttribute("box") Box box, BindingResult result){
			
		if (result.hasErrors()) {
			return "myTeams.jsp";
		}
		boxService.createBox(box);
		return "redirect:/tvguide";
	}
	
	
	//Read
	
		@PostMapping("/login")
		public String login(Model model, @Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, HttpSession session){
			User user = userService.login(newLogin, result);
			if(result.hasErrors()) {
				model.addAttribute("newUser", new User());
				return "index.jsp";
			}
			session.setAttribute("userName", user.getName());
			session.setAttribute("userId", user.getId());
			return "redirect:/";
		}
	
		@GetMapping("/dashboard")
		public String tvguide(Model model, HttpSession session) {
			if(session.getAttribute("userId" ) == null) {
				return "redirect:/";
			}
			model.addAttribute("box", boxService.allBoxes());
			model.addAttribute("user", userService.findById((Long)session.getAttribute("userId")));
			return "box.jsp";
		}
		
	
	
	
	//Update
	
		@GetMapping("/box/{id}/edit")
		public String edit(Model model, @PathVariable("id") Long id, HttpSession session) {
			if(session.getAttribute("userId") == null) {
				return "redirect:/";
			}
			Box box = boxService.findById(id);
			model.addAttribute("box", box);
			
			return "box.jsp";
		}
		
		@PostMapping("/box/edit/submit/{id}")
		public String submitUpdate(Model model, @Valid @ModelAttribute("tvshow") Box box, BindingResult result) {
			if(result.hasErrors()) {
				return "box.jsp";
			}
			boxService.updateBox(box);
			
			return "redirect:/dashboard";
		}
	
	
	//Delete
	
		@GetMapping("/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "redirect:/";
		}
		
		@GetMapping("/box/{id}/delete")
		public String delete(@PathVariable("id") Long id) {
			boxService.deleteBox(id);
			
			return "redirect:/box";
		}
	
	
}
