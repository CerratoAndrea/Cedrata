package com.its.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.its.quiz.entities.Score;
import com.its.quiz.entities.User;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
	
    List<Score> findByUserOrderByIdDesc(User user);
    
    List<Score> findByUserAndSessioneOrderById(User user, long sessione);
    
    @Query("SELECT s.user.username, COUNT(s), SUM(CASE WHEN s.corretto = true THEN 1 ELSE 0 END) " +
     	   "FROM Score s WHERE s.difficolta = :livello GROUP BY s.user.username ORDER BY 3 DESC")
    List<Object[]> getClassifica(@Param("livello") String livello);

}


