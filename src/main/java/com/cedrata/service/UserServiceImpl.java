package com.cedrata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cedrata.entities.User;
import com.cedrata.repos.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo dao;
	
	@Autowired
	 private PasswordEncoder passwordEncoder;	//crittatore di password

	@Override
	public List<User> getUtenti() {
		return dao
        		.findAll();
	}

	@Override
	public User getUtenteById(Long id) {
		return dao.findById(id)
        		.orElse(null);
	}

	@Override
	public User addUtente(User u) {
		 u.setPassword(passwordEncoder.encode(u.getPassword()));
	    	return dao
	        		.save(u);
	}

	@Override
	public boolean existsByUsername(String username) {
		return dao.findByUsername(username) != null;
	}

}
