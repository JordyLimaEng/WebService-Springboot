package com.jordy.projetoweb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jordy.projetoweb.entities.Product;
import com.jordy.projetoweb.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	@GetMapping//especifica que vai responder uma requisição GET em /users
	public ResponseEntity<List<Product>> findAll(){//resonde uma lista de user
		List<Product> list = service.findAll(); 
		return ResponseEntity.ok().body(list);//responde lista - via http ok
	}
	
	@GetMapping(value = "/{Id}")
	public ResponseEntity<Product> findById(@PathVariable Long Id){//@PathVariable é usado para dizer que vai receber o id via url
		Product obj = service.findById(Id);
		return ResponseEntity.ok().body(obj);
	}
	
}
