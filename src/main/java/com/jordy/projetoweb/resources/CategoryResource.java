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

//Controlador REST das requisições em /categories
@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	//SELECT ALL
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	//SELECT by Id
	//recebe como paramêtro o ID da categoria via URI e responde a categoria correspondente
	@GetMapping(value = "/{Id}")
	public ResponseEntity<Category> findById(@PathVariable Long Id){//@PathVariable é usado para dizer que vai receber o id via url
		Category obj = service.findById(Id);
		return ResponseEntity.ok().body(obj);
	}
	
}
