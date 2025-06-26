package com.cedrata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cedrata.entities.Country;
import com.cedrata.service.CountryServiceImpl;

@Controller
public class CountryController {

	@Autowired
	CountryServiceImpl service;
	
	@GetMapping("/countries")
	public String getCountries(Model m) {
		m.addAttribute("paesi", service.getCountries());
		return "paesi";
		
	}
	
	@GetMapping("/country")
	public String mostraDettaglio(@RequestParam("code") String code, Model model) {
		Country country = service.getByAlpha2Code(code);
		model.addAttribute("country", country);
		model.addAttribute("languageNames", country.getLanguageNames());
		return "paese"; // paese.html
	}
	
	
}
