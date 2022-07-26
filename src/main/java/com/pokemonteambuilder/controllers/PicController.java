package com.pokemonteambuilder.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pokemonteambuilder.models.User;
import com.pokemonteambuilder.services.PicServ;
import com.pokemonteambuilder.services.UserService;



@Controller
public class PicController {
	@Autowired
	UserService userServ;
	
	@Autowired
	PicServ picServ;

	private static String UPLOADED_FOLDER = "src/main/resources/static/images/";
	
	@PostMapping("/pictures/profile/add")
	public String newProfPic(@RequestParam("url") MultipartFile file, HttpSession session, RedirectAttributes redirectedAttrs) {
		if(file.isEmpty()) {
			redirectedAttrs.addFlashAttribute("message", "Upload field cannot be empty");
			return "redirect:/my/fish";
		}
		
		try {
			User user = userServ.findById((Long) session.getAttribute("userId"));

			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
			
			String imageUrl = "/images/" + file.getOriginalFilename();
			picServ.addProPic(imageUrl, user);
		}
		catch(IOException e) {
			e.printStackTrace();
		}

		return "redirect:/dashboard";
	}
}
