package com.jordy.projetoweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jordy.projetoweb.entities.Order;
import com.jordy.projetoweb.repositories.OrderRepository;

@Service// registra a classe como um serviço
public class OrderService {//camada de serviço
	
	@Autowired
	private	OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long Id){
		Optional<Order> obj = repository.findById(Id);
		return obj.get();
	}
}
