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
	
	//recupera uma lista com todas as categorias do banco de dados
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	//retorna um objeto contendo a categoria requisitada por id no BD
	public Category findById(Long Id){
		Optional<Category> obj = repository.findById(Id);
		return obj.get();
	}
	
	//Deleta uma determinada categoria do banco de dados
	public void Delete(Long Id){
		repository.deleteById(Id);
	}
}
