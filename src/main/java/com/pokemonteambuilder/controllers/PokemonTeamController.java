package com.pokemonteambuilder.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pokemonteambuilder.models.Box;
import com.pokemonteambuilder.models.Discussion;
import com.pokemonteambuilder.models.LoginUser;
import com.pokemonteambuilder.models.Pokemon;
import com.pokemonteambuilder.models.Team;
import com.pokemonteambuilder.models.User;
import com.pokemonteambuilder.services.BoxService;
import com.pokemonteambuilder.services.DiscussionService;
import com.pokemonteambuilder.services.PokemonService;
import com.pokemonteambuilder.services.TeamService;
import com.pokemonteambuilder.services.UserService;

@Controller
public class PokemonTeamController {

	@Autowired
	TeamService teamService;
	@Autowired
	UserService userService;
	@Autowired
	DiscussionService discussionService;
	@Autowired
	BoxService boxService;
	@Autowired
	PokemonService pokeServ;

	// index
	
	
	//index
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		
		Page<Discussion> pageDiscussions = discussionService.getDiscussionPage(0, 10);
		model.addAttribute("discussions", pageDiscussions.getContent());
		
		return "index.jsp";
	}

	// Create

	@PostMapping("/createUser")
	public String registerUser(Model model, @Valid @ModelAttribute("newUser") User newUser, BindingResult result,
			HttpSession session) {
		User user = userService.register(newUser, result);
		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			
			Page<Discussion> pageDiscussions = discussionService.getDiscussionPage(0, 10);
			model.addAttribute("discussions", pageDiscussions.getContent());
			return "index.jsp";
		}
		session.setAttribute("userName", user.getName());
		session.setAttribute("userId", user.getId());
		return "redirect:/dashboard"; // homepage for user "Hello User"
	}

	@PostMapping("/discussion/submit")
	public String submitDiscussion(Model model, @RequestParam(defaultValue = "0") int page, @Valid @ModelAttribute("newDiscussion") Discussion discussion, BindingResult result, HttpSession session) {
		if(discussion.getUser().getId() != (long)session.getAttribute("userId")) {
			return "redirect:/";
		}
		
		if (result.hasErrors()) {
			Page<Discussion> pageDiscussions = discussionService.getDiscussionPage(page, 10);
			
			model.addAttribute("discussions", pageDiscussions.getContent());
			model.addAttribute("currentPage", pageDiscussions.getNumber());
			model.addAttribute("totalPages", pageDiscussions.getTotalPages());
			
			return "discussion.jsp";
		}
		discussionService.createDiscussion(discussion);
		return "redirect:/discussion";
	}

	@GetMapping("/team/submit/{id}")
	public String addNewTeam(@PathVariable("id") Long id) {

		teamService.createTeam(boxService.findById(id));
		return "redirect:/dashboard";
	}

	@GetMapping("/box/submit")
	public String addNewBox(@ModelAttribute("box") Box box, BindingResult result, HttpSession session) {
		User user = userService.findById((Long) session.getAttribute("userId"));
		List<Box> boxes = user.getBoxes();
		if (boxes.size() < 6) {
			boxService.createBox(box, user);
		}
		return "redirect:/dashboard";
	}
	@PostMapping("/pokemon/add/{id}")
	public String addPokemon(@PathVariable("id") Long id, @Valid @ModelAttribute("newPokemon") Pokemon poke, BindingResult result, Model model) {
		Team team = teamService.findById(id);
		if(result.hasErrors()) {
			model.addAttribute("team", team);
			return "ViewTeam.jsp";
		}
		else {
		
		pokeServ.createPokemon(poke, id);
		return "redirect:/team/" + id;
		}
	}
	
	
	//Read
	
		@PostMapping("/login")
		public String login(Model model, @Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, HttpSession session){
			User user = userService.login(newLogin, result);
			if(result.hasErrors()) {
				model.addAttribute("newUser", new User());
				
				Page<Discussion> pageDiscussions = discussionService.getDiscussionPage(0, 10);
				model.addAttribute("discussions", pageDiscussions.getContent());
				
				return "index.jsp";
			}
			session.setAttribute("userName", user.getName());
			session.setAttribute("userId", user.getId());
			return "redirect:/dashboard";
		}
	
		@GetMapping("/dashboard")
		public String tvguide(Model model, HttpSession session) {
			if (session.getAttribute("userId") == null) {
				return "redirect:/";
			}
			User user = userService.findById((Long) session.getAttribute("userId"));
			List<Box> boxes = user.getBoxes();
			model.addAttribute("boxes", boxes);
			model.addAttribute("user", user);
			return "Dashboard.jsp";
		}
		@GetMapping("/box/{id}")
		public String viewBox(Model model, HttpSession session, @PathVariable("id") Long boxId) {

			if(session.getAttribute("userId" ) == null) {
				return "redirect:/";
			}
			model.addAttribute("box", boxService.findById(boxId));
			
			return "ViewBox.jsp";
			
		}
	
		@GetMapping("/team/{id}")
		public String viewTeam(@PathVariable("id") Long teamId, @ModelAttribute("newPokemon") Pokemon poke, Model model, HttpSession session) {
			if(session.getAttribute("userId" ) == null) {
				return "redirect:/";
			}
			model.addAttribute("team", teamService.findById(teamId));
			model.addAttribute("newPokemon", poke);
			
			return "ViewTeam.jsp";
		}
		
		@GetMapping("/discussion")
		public String discussion(Model model, @RequestParam(defaultValue = "0") int page, @ModelAttribute("newDiscussion") Discussion newDiscussion, HttpSession session) {				
			Page<Discussion> pageDiscussions = discussionService.getDiscussionPage(page, 10);
			
			model.addAttribute("discussions", pageDiscussions.getContent());
			model.addAttribute("currentPage", pageDiscussions.getNumber());
			model.addAttribute("totalPages", pageDiscussions.getTotalPages());
			
			return "discussion.jsp";
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
		if (result.hasErrors()) {
			return "box.jsp";
		}
		boxService.updateBox(box);

		return "redirect:/dashboard";
	}

	// Delete

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/box/{id}/delete")
	public String deleteBox(@PathVariable("id") Long id) {
		boxService.deleteBox(id);

		return "redirect:/dashboard";
	}
	@GetMapping("/pokemon/{id}/delete")
	public String deletePokemon(@PathVariable("id") Long id) {
		Pokemon pokemon = pokeServ.findPokemon(id);
		Long teamId = pokemon.getPokemonTeam().getId();
		pokeServ.deletePokemon(pokemon);
		
		return "redirect:/team/" + teamId;
	}
	

}
