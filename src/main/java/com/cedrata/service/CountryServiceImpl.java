package com.cedrata.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cedrata.entities.Country;
import com.cedrata.repos.CountryRepo;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepo repo;
	
	@Override
	public List<Country> getCountries() {

		return repo.findAll();
	}

	@Override
	public Country getCountryById(String alpha2) {

		return repo.findById(alpha2).get();
	}

	@Override
	public Country getCountryByRand() {
		
		Random r = new Random();
		int random = r.nextInt(0, getCountries().size());
		
		return getCountries().get(random);
	}

}
