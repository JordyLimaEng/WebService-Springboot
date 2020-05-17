package com.jordy.projetoweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jordy.projetoweb.entities.Category;
import com.jordy.projetoweb.repositories.CategoryRepository;

@Service// registra a classe como um serviço
public class CategoryService {//camada de serviço
	
	@Autowired
	private	CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long Id){
		Optional<Category> obj = repository.findById(Id);
		return obj.get();
	}
}
