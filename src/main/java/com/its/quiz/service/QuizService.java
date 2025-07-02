package com.its.quiz.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.its.quiz.dto.Quiz;
import com.its.quiz.entities.Country;
import com.its.quiz.repository.CountryRepository;

@Service
public class QuizService {

    @Autowired
    private CountryRepository countryRepository;

    public Quiz creaDomanda(String difficolta) {
        List<Country> paesi = countryRepository.findAll();
        Collections.shuffle(paesi);

        Quiz quiz = new Quiz();

        //random tra capitale o lingua e popolazione a seconda della difficoltà
        String tipo;
        double random = Math.random();

        switch (difficolta.toLowerCase()) {
            case "facile":
                // solo capitale o bandiera
                tipo = random < 0.5 ? "capitale" : "bandiera";
                break;
            case "normale":
                // capitale, bandiera o lingua
                if (random < 0.33)
                    tipo = "capitale";
                else if (random < 0.66)
                    tipo = "bandiera";
                else
                    tipo = "lingua";
                break;
            case "difficile":
            default:
                // capitale, lingua, popolazione, bandiera
                if (random < 0.25)
                    tipo = "capitale";
                else if (random < 0.5)
                    tipo = "lingua";
                else if (random < 0.75)
                    tipo = "popolazione";
                else
                    tipo = "bandiera";
                break;
        }

        quiz.setTipo(tipo);
        
        int numeroDomande = 3;
        
        if(difficolta.equals("normale"))
        	numeroDomande = 4;
        	
        if(difficolta.equals("difficile"))
        	numeroDomande = 5;

        if (tipo.equals("capitale")) {
            Country corretto = paesi.stream()
                                    .filter(c -> c.getCapital() != null && !c.getCapital().isBlank())
                                    .findFirst()
                                    .orElse(paesi.get(0));

            List<String> listaOpzioni = new ArrayList<>();
            listaOpzioni.add(corretto.getCapital());

            int i = 1;
            while (listaOpzioni.size() < numeroDomande && i < paesi.size()) {
                String capitaleErrata = paesi.get(i).getCapital();
                if (capitaleErrata != null 
                		&& !listaOpzioni.contains(capitaleErrata)) {
                	listaOpzioni.add(capitaleErrata);
                }
                i++;
            }

            Collections.shuffle(listaOpzioni);

            quiz.setDomanda("Qual è la capitale di " + corretto.getName() + "?");
            quiz.setOpzioni(listaOpzioni);
            quiz.setRispostaCorretta(corretto.getCapital());

        } else if (tipo.equals("lingua")) {
                       
            Country corretto = paesi.stream()
                                    .filter(c -> c.getLanguages() != null && !c.getLanguages().isBlank())
                                    .findFirst()
                                    .orElseThrow(() -> new RuntimeException("Nessun paese con lingue valide trovato"));

            String[] rispostaCorretta = corretto.getLanguages().split(",");

            List<String> listaOpzioni = new ArrayList<>();
            listaOpzioni.add(rispostaCorretta[0]);

            int i = 1;
            while (listaOpzioni.size() < numeroDomande && i < paesi.size()) {
                    Country candidato = paesi.get(i++);
                    String languages = candidato.getLanguages();
                    if(languages != null) {
	                    String[] alternativa = languages.split(",");
	                    if (alternativa != null && !listaOpzioni.contains(alternativa[0])) {
	                    	listaOpzioni.add(alternativa[0]);
	                    }
                    }
            }

            Collections.shuffle(listaOpzioni);

            quiz.setDomanda("Qual è una lingua ufficiale di " + corretto.getName() + "?");
            quiz.setOpzioni(listaOpzioni);
            quiz.setRispostaCorretta(rispostaCorretta[0]);
        }
        else if (tipo.equals("bandiera")) {
            Country corretto = paesi.stream()
                    .filter(c -> c.getAlpha2Code() != null && !c.getAlpha2Code().isBlank())
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Nessun paese con codice Alpha2 valido"));

            List<String> listaOpzioni = new ArrayList<>();
            listaOpzioni.add(corretto.getAlpha2Code());

            int i = 1;
            while (listaOpzioni.size() < numeroDomande && i < paesi.size()) {
                String code = paesi.get(i++).getAlpha2Code();
                if (code != null && !listaOpzioni.contains(code)) {
                    listaOpzioni.add(code);
                }
            }

            Collections.shuffle(listaOpzioni);

            quiz.setDomanda("Qual è la bandiera di " + corretto.getName() + "?");
            quiz.setOpzioni(listaOpzioni);
            quiz.setRispostaCorretta(corretto.getAlpha2Code());
        } 
        
        else {	//blocco popolazione
        	Country corretto = paesi.stream()
                                    .filter(c -> c.getPopulation() != null)
                                    .findFirst()
                                    .orElseThrow(() -> new RuntimeException("Nessun paese con popolazione valida trovato"));

            String rispostaCorretta = ""+corretto.getPopulation();

            List<String> listaOpzioni = new ArrayList<>();
            listaOpzioni.add(rispostaCorretta);

            int i = 1;
            while (listaOpzioni.size() < numeroDomande && i < paesi.size()) {
                    Country candidato = paesi.get(i++);
                    String alternativa = ""+candidato.getPopulation();
                    if (alternativa != null && !listaOpzioni.contains(alternativa)) {
                    	listaOpzioni.add(alternativa);
                    }
            }

            Collections.shuffle(listaOpzioni);

            quiz.setDomanda("Quanti sono gli abitanti di " + corretto.getName() + "?");
            quiz.setOpzioni(listaOpzioni);
            quiz.setRispostaCorretta(rispostaCorretta);
        }

        return quiz;
    }
}
