package com.jordy.projetoweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jordy.projetoweb.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
