package com.cedrata.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	 @GetMapping("/")
	    public String home() {
	        return "home"; // carica home.html da /templates
	    }

	    @GetMapping("/allenamento")
	    public String allenamento() {
	        return "allenamento"; // da fare
	    }

	    @GetMapping("/quiz")
	    public String quiz() {
	        return "quiz"; // da fare
	    }
	
}
