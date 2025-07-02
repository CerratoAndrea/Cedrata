package com.its.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.its.quiz.entities.Score;
import com.its.quiz.entities.User;
import com.its.quiz.repository.ScoreRepository;

@Service
public class ScoreService {

	@Autowired
    private ScoreRepository scoreRepository;
	
	public void saveScore(Score score) {
		scoreRepository.save(score);
	}
	
	public List<Score> findByUser(User user){
		return scoreRepository.findByUserOrderByIdDesc(user);
	}
	
	public List<Score> findByUserAndSessione(User user, long sessione){
		return scoreRepository.findByUserAndSessioneOrderById(user, sessione);
	}
	
	public  List<Object[]> getClassifica(String livello){
		return scoreRepository.getClassifica(livello);
	}
}
