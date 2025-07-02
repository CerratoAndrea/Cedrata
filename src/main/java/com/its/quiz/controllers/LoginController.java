package com.its.quiz.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.its.quiz.entities.User;
import com.its.quiz.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;	
	    
	@GetMapping("/")
	public String loginForm() {
	    return "login";
	}
	
	@GetMapping("/login")
    public String login() {
        return "login";
    }
	
	@GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String processForm(@ModelAttribute("user") User user, Model model) {
        return userService.registerUser(user, model);
    }
	
	@GetMapping("/home")
	public String home(Model model, Principal principal) {
		model.addAttribute("username", principal.getName().toUpperCase());
	    return "home";
	}
	
}

