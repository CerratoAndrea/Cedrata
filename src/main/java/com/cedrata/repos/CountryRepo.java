package com.cedrata.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cedrata.entities.Country;

public interface CountryRepo extends JpaRepository<Country, String>{
	
	Country findByAlpha2code(String alpha2code);

}
