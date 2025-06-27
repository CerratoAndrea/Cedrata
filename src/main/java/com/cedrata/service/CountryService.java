package com.cedrata.service;

import java.util.List;

import com.cedrata.entities.Country;

public interface CountryService {

	Country getByAlpha2Code(String code);
	List<Country> getCountries();
	Country getCountryByAlpha2code(String alpha2);
	Country getCountryByRand();
	Country getCountryById(Long id);
}
