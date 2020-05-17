package com.jordy.projetoweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jordy.projetoweb.entities.User;
import com.jordy.projetoweb.repositories.UserRepository;

@Service// registra a classe como um serviço
public class UserService {//camada de serviço
	
	@Autowired
	private	UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long Id){
		Optional<User> obj = repository.findById(Id);
		return obj.get();
	}
}
