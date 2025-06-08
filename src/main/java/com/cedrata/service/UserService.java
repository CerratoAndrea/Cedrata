package com.cedrata.service;

import java.util.List;

import com.cedrata.entities.User;


public interface UserService {
	
    List<User> getUtenti();
    User getUtenteById(Long id);
    User addUtente(User u);
    boolean existsByUsername(String username);

}
