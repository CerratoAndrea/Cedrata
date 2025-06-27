package com.cedrata.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cedrata.entities.Country;

public interface CountryRepo extends JpaRepository<Country, String>{
	
	Country findByAlpha2code(String alpha2code);
	
	Country findById(Long id);
	
	@Query(value = "SELECT * FROM countries WHERE id = ?1", nativeQuery = true)
    Country findCountryById(Long id);
	
	
}
