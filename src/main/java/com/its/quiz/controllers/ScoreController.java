package com.its.quiz.controllers;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.its.quiz.entities.Score;
import com.its.quiz.entities.User;
import com.its.quiz.service.ScoreService;
import com.its.quiz.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ScoreController {
	
	@Autowired
    private UserService userService;
    
    @Autowired
    private ScoreService scoreService;

    @GetMapping("/score")
    public String mostraRisultati(Model model,
    		                      Principal principal) {

        return getScore(model, principal, null);
    }
    
    @GetMapping("/score_sessione")
    public String mostraRisultatiSessione(Model model, 
    		                              Principal principal,
                                          HttpSession session) {
        
    	Long sessione = (Long)session.getAttribute("session_"+principal.getName());
    	return getScore(model, principal, sessione);
    }
    
    private String getScore(Model model, 
    						Principal principal,
    		                Long sessioneUtente) {
    	
    	String username = principal.getName();
        Optional<User> optionalUser = userService.findByUsername(username);

        if (optionalUser.isPresent()) {
        	
        	List<Score> punteggi = null;
        	
        	if(sessioneUtente != null)
        		punteggi = scoreService.findByUserAndSessione(optionalUser.get(), sessioneUtente);
        	else
        		punteggi = scoreService.findByUser(optionalUser.get());

            long totali = punteggi.size();
            long corrette = punteggi.stream().filter(Score::isCorretto).count();
            double percentuale = totali > 0 ? (corrette * 100.0 / totali) : 0;

            model.addAttribute("punteggi", punteggi);
            model.addAttribute("username", username.toUpperCase());
            model.addAttribute("percentuale", percentuale);
        }

        return "score";
    }
    
    @GetMapping("/classifica")
    public String classificaPerLivello(Model model) {
    	
        model.addAttribute("facile", scoreService.getClassifica("facile"));
        model.addAttribute("normale", scoreService.getClassifica("normale"));
        model.addAttribute("difficile", scoreService.getClassifica("difficile"));
        
        return "classifica";
    }

}

