package com.cedrata.service;

import java.util.List;

import com.cedrata.entities.Question;

public interface QuizService {

	List<Question> generaQuiz(String difficolta);
	
}
