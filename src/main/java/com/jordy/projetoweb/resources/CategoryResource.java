package com.jordy.projetoweb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jordy.projetoweb.entities.Category;
import com.jordy.projetoweb.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping//especifica que vai responder uma requisição GET em /users
	public ResponseEntity<List<Category>> findAll(){//resonde uma lista de user
		List<Category> list = service.findAll(); 
		return ResponseEntity.ok().body(list);//responde lista - via http ok
	}
	
	@GetMapping(value = "/{Id}")
	public ResponseEntity<Category> findById(@PathVariable Long Id){//@PathVariable é usado para dizer que vai receber o id via url
		Category obj = service.findById(Id);
		return ResponseEntity.ok().body(obj);
	}
	
}
