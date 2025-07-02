package com.its.quiz.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.its.quiz.entities.User;
import com.its.quiz.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public String registerUser(@ModelAttribute("user") User user, Model model) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            model.addAttribute("error", "Username già registrato!");
            return "register";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER"); // ruolo base
        userRepository.save(user);
        
        return "login";
    }
	
	public Optional<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
    }

}
