package com.jordy.projetoweb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jordy.projetoweb.entities.Order;
import com.jordy.projetoweb.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	@GetMapping//especifica que vai responder uma requisição GET em /users
	public ResponseEntity<List<Order>> findAll(){//resonde uma lista de user
		List<Order> list = service.findAll(); 
		return ResponseEntity.ok().body(list);//responde lista - via http ok
	}
	
	@GetMapping(value = "/{Id}")
	public ResponseEntity<Order> findById(@PathVariable Long Id){//@PathVariable é usado para dizer que vai receber o id via url
		Order obj = service.findById(Id);
		return ResponseEntity.ok().body(obj);
	}
	
}
