package com.cedrata.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cedrata.entities.Country;
import com.cedrata.service.CountryServiceImpl;

@Controller
public class QuizListController {
	
	 @Autowired
	 CountryServiceImpl countryService;
	
	@GetMapping("/quizCapitali")
    public String quizCapitali(Model model) {
		
		getRandomCountries(model);
		model.addAttribute("TipoQuiz", "Quiz Capitali");
		
        return "quiz"; 
    }
	
	@GetMapping("/quizBandiera")
    public String quizBandiera(Model model) {
		getRandomCountries(model);
		model.addAttribute("TipoQuiz", "Quiz Bandiere");
        return "quiz"; // 
    }
	@GetMapping("/quizLingue")
    public String quizLingue(Model model) {
		getRandomCountries(model);
		model.addAttribute("TipoQuiz", "Quiz Lingue");
        return "quiz"; // 
    }
	@GetMapping("/quizConfini")
    public String quizConfini(Model model) {
		
		getRandomCountries(model);
		model.addAttribute("TipoQuiz", "Quiz Confini");
		
        return "quiz"; 
    }
	

    
    private void getRandomCountries(Model model) {
    	List<Country> risposte = new ArrayList<Country>();
		for (int i = 1; i <= 4; i++) {
			risposte.add(countryService.getCountryByRand());
		}
		Random r = new Random();
		int random = r.nextInt(1, 4);
		Country rispostaEsatta = risposte.get(random);
		model.addAttribute("RispostaEsatta", rispostaEsatta);
		model.addAttribute("Risposte", risposte);
    }
	
	
	
}
