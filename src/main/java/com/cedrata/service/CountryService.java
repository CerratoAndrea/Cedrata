package com.cedrata.service;

import java.util.List;

import com.cedrata.entities.Country;

public interface CountryService {

	List<Country> getCountries();
	Country getCountryById(String alpha2);
	Country getCountryByRand();
	
}
