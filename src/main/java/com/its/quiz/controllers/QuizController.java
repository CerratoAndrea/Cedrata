package com.its.quiz.controllers;

import java.security.Principal;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.its.quiz.dto.Quiz;
import com.its.quiz.entities.Country;
import com.its.quiz.entities.Score;
import com.its.quiz.entities.User;
import com.its.quiz.service.CountryService;
import com.its.quiz.service.QuizService;
import com.its.quiz.service.ScoreService;
import com.its.quiz.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class QuizController {
	
	@Autowired
	ScoreController scoreController;

    @Autowired
    private QuizService quizService;
    
    @Autowired
    private CountryService countryService;

    @Autowired
    private UserService userService;
    
    @Autowired
    private ScoreService scoreService;

    @GetMapping("/quiz")
    public String mostraDomanda(@RequestParam(defaultValue = "normale") String difficolta,
            					@RequestParam(defaultValue = "0") int numeroDomanda,
            					Model model,
            					Principal principal,
            					HttpSession session) {
    	
    	if(numeroDomanda == 0)
    		session.setAttribute("session_"+principal.getName(), new Date().getTime());
    	
        Quiz quiz = quizService.creaDomanda(difficolta);
        quiz.setNumeroDomanda(numeroDomanda+1);
        quiz.setDifficolta(difficolta);

        model.addAttribute("quiz", quiz);
        model.addAttribute("esito", null);
        model.addAttribute("numeroDomanda", numeroDomanda+1);
        
        return "quiz";
    }
    
    @GetMapping("/allenamento")
    public String allenamento(Model model) {
    	
    	Quiz quiz = quizService.creaDomanda("normale");
        quiz.setDifficolta("normale");
        quiz.setNumeroDomanda(0);

        model.addAttribute("quiz", quiz);
        model.addAttribute("esito", null);
        quiz.setNumeroDomanda(0);
        
        return "training";
    }

    @PostMapping("/quiz")
    public String verificaRisposta(@ModelAttribute Quiz quiz,     		                       
    		                       @RequestParam(defaultValue = "0") int numeroDomanda,
    		                       Model model,
    		                       Principal principal,
    		                       HttpSession session) {        
        
        boolean rispostaCorretta = false;
        String rispostaUtente = quiz.getRispostaUtente();
        String correttaValida = quiz.getRispostaCorretta();

        String esito;
        String tipo = quiz.getTipo();

        // Per bandiere: costruisci risposta descrittiva con immagine
        String rispDescr = correttaValida;

        System.out.println("TIPO DEL QUIZ: " + tipo);
        System.out.println("RISPOSTA CORRETTA GREZZA: " + correttaValida);
        
        if ("bandiera".equalsIgnoreCase(tipo)) {
            Country paeseCorretto = countryService.findAll().stream()
                .filter(c -> c.getAlpha2Code() != null && c.getAlpha2Code().equalsIgnoreCase(correttaValida))
                .findFirst()
                .orElse(null);

            if (paeseCorretto != null) {
                String codice = paeseCorretto.getAlpha2Code().toLowerCase(); // per .png
                String nome = paeseCorretto.getName();

                rispDescr = "la bandiera di " + nome +
                    "<br><img src='/flags/" + codice + ".png' style='width:100px; border: 1px solid #ccc; padding: 5px;'>";
            }
        }

        if (rispostaUtente == null) {
            esito = "<strong>Tempo scaduto!</strong><br>La risposta corretta era: " + rispDescr;
        } else if (rispostaUtente.equalsIgnoreCase(correttaValida)) {
            esito = "<strong>Risposta corretta!</strong>";
            rispostaCorretta = true;
        } else {
            esito = "<strong>Sbagliato ahahaha!</strong><br>La risposta corretta era: " + rispDescr;
        }
        
        // quiz vero -> salvo lo score
        // se numeroDomanda = 0 -> training
        if(numeroDomanda > 0) {
	        Optional<User> optionalUser = userService.findByUsername(principal.getName());
	
	        if (optionalUser.isPresent()) {	
	            Score score = new Score();
	            score.setUser(optionalUser.get());
	            score.setDomanda(quiz.getDomanda());
	            score.setRispostaUtente(rispostaUtente); // può essere null
	            score.setRispostaCorretta(correttaValida);
	            score.setCorretto(rispostaCorretta);
	            score.setDifficolta(quiz.getDifficolta());
	            score.setSessione((Long)session.getAttribute("session_"+principal.getName()));
	            
	            scoreService.saveScore(score);
	        }        
        }
        
        quiz.setNumeroDomanda(numeroDomanda);
        
        model.addAttribute("quiz", quiz);
        model.addAttribute("esito", esito);
        model.addAttribute("numeroDomanda", numeroDomanda);
        
        if(numeroDomanda > 0) 
        	return "quiz";
        else
        	return "training";
    }
    
    @GetMapping("/paesi")
    public String paesi(Model model) {
        List<Country> countryList = countryService.findAll();
        Collections.sort(countryList, Comparator.comparing(Country::getName));
        
        model.addAttribute("countries", countryList);
        return "paesi";
    }
    
}
