package com.cedrata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cedrata.service.CountryServiceImpl;

@Controller
public class HomeController {

	@Autowired
	CountryServiceImpl countryService;
	
	 @GetMapping("/")
	    public String home() {
	        return "home"; // carica home.html da /templates
	    }

	 @GetMapping("/allenamento")
	 public String allenamento(Model model) {
	     model.addAttribute("paese", countryService.getCountryByRand());
	     return "allenamento";
	 }

	    @GetMapping("/quiz")
	    public String quiz() {
	        return "quizLista"; // da fare
	    }
	    
	
}
