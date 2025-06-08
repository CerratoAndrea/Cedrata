package com.cedrata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cedrata.service.CountryServiceImpl;

@Controller
public class CountryController {

	@Autowired
	CountryServiceImpl service;
	
	@GetMapping("countries")
	public String getCountries(Model m) {
		m.addAttribute("paesi", service.getCountries());
		return "paesi";
		
	}
	
	
}
