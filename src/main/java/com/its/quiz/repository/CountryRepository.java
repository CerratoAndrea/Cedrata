package com.its.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.its.quiz.entities.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
	
}
