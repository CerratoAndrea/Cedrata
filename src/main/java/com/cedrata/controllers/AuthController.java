package com.cedrata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cedrata.entities.User;
import com.cedrata.service.UserService;

import jakarta.validation.Valid;

@Controller
public class AuthController {

	@Autowired
	private UserService utenteService;
	
	@GetMapping("/register")
	public String mostraFormRegistrazione(Model model) {
		model.addAttribute("utente", new User());
        return "register";
	}
	
	
	@PostMapping("/register")
	public String processRegister(@Valid @ModelAttribute("utente") User user,
                              BindingResult result,
                              Model model) {


    if (utenteService.existsByUsername(user.getUsername())) {
        result.rejectValue("username", "error.utente", "Username già esistente");
    }

    if (result.hasErrors()) {
        return "register";
    }

    utenteService.addUtente(user);
    return "redirect:/login";

	}
	 
	 @GetMapping("/login")
	    public String showLoginForm() {
	        return "login";
	}
	
}
