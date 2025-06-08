package com.cedrata.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cedrata.entities.User;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public List<User> getUtenti() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUtenteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addUtente(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsByUsername(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
