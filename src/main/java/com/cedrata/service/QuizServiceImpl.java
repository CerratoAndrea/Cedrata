package com.cedrata.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cedrata.entities.Country;
import com.cedrata.entities.Question;

@Service
public class QuizServiceImpl implements QuizService{
	
	@Autowired
	private CountryService countryService;

	private static final Random random = new Random();
	
	@Override
    public List<Question> generaQuiz(String difficulty) {
        List<Country> allCountries = countryService.getCountries();
        List<Question> questions = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            Country correct = getRandomCountry(allCountries);
            String questionText;
            String correctAnswer;
            List<String> wrongAnswers = new ArrayList<>();

            // Choose question type
            int type = random.nextInt(3);
            switch (type) {
                case 0: // Capital
                    questionText = "What is the capital of " + correct.getName() + "?";
                    correctAnswer = correct.getCapital();
                    wrongAnswers = getWrongCapitals(allCountries, correct);
                    break;
                case 1: // Language
                    questionText = "Which language is spoken in " + correct.getName() + "?";
                    correctAnswer = correct.getLanguageNames().get(0); // first language
                    wrongAnswers = getWrongLanguages(allCountries, correct);
                    break;
                case 2: // Population
                    questionText = "What is the population of " + correct.getName() + "?";
                    correctAnswer = correct.getPopulation();
                    wrongAnswers = getWrongPopulations(allCountries, correct);
                    break;
                default:
                    questionText = "Unknown question";
                    correctAnswer = "?";
                    break;
            }

            Collections.shuffle(wrongAnswers);
            
//            questions.add(new Question(questionText, correctAnswer, wrongAnswers));
        }

        return questions;
    }

    private Country getRandomCountry(List<Country> countries) {
        return countries.get(random.nextInt(countries.size()));
    }

    private List<String> getWrongCapitals(List<Country> countries, Country exclude) {
        return countries.stream()
                .filter(c -> !c.getAlpha2code().equals(exclude.getAlpha2code()) && c.getCapital() != null)
                .limit(10)
                .map(Country::getCapital)
                .distinct()
                .limit(2)
                .toList();
    }

    private List<String> getWrongLanguages(List<Country> countries, Country exclude) {
        List<String> wrong = new ArrayList<>();
        for (Country c : countries) {
            if (!c.getAlpha2code().equals(exclude.getAlpha2code())) {
                List<String> langs = c.getLanguageNames();
                if (!langs.isEmpty()) {
                    wrong.add(langs.get(0));
                }
            }
            if (wrong.size() >= 2) break;
        }
        return wrong;
    }

    private List<String> getWrongPopulations(List<Country> countries, Country exclude) {
        return countries.stream()
                .filter(c -> !c.getAlpha2code().equals(exclude.getAlpha2code()))
                .limit(10)
                .map(Country::getPopulation)
                .distinct()
                .limit(2)
                .toList();
    }
	
	
}
