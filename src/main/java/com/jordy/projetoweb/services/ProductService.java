package com.jordy.projetoweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jordy.projetoweb.entities.Product;
import com.jordy.projetoweb.repositories.ProductRepository;

@Service// registra a classe como um serviço
public class ProductService {//camada de serviço
	
	@Autowired
	private	ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long Id){
		Optional<Product> obj = repository.findById(Id);
		return obj.get();
	}
}
