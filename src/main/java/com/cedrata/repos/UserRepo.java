package com.cedrata.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cedrata.entities.User;

public interface UserRepo extends JpaRepository<User, Long>{

	//login
	User findByUsername(String username);
	
}
