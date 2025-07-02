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
}

