package com.its.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.its.quiz.entities.Country;
import com.its.quiz.repository.CountryRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> findAll() {
        return countryRepository.findAll();
    }
    
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    public Country getByAlpha2Code(String code) {
        return countryRepository.findByAlpha2Code(code);
    }
}

