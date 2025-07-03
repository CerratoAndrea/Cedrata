package com.its.quiz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.its.quiz.entities.Country;
import com.its.quiz.service.CountryService;

@Controller
public class CountryController {

	@Autowired
	CountryService service;
	
	 @GetMapping("/countries")
	    public String mostraMappa(Model model) {
	        List<Country> paesi = service.getCountries();
	        model.addAttribute("paesi", paesi);
	        return "paesi";
	    }
	
	  @GetMapping("/country")
	    public String mostraDettaglio(@RequestParam("code") String code, Model model) {
	        Country country = service.getByAlpha2Code(code);
	        model.addAttribute("country", country);
	        model.addAttribute("languageNames", country.getLanguageNames());
	        return "paese";
	    }
	
}
