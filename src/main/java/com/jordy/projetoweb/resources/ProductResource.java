package com.jordy.projetoweb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jordy.projetoweb.entities.Product;
import com.jordy.projetoweb.services.ProductService;

//Controlador REST das requisições em /products
@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	//SELECT ALL
	//responde com todos os produtos cadastrados
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	//SELECT by Id
	//recebe como paramêtro o ID via URI e responde com o produto especificado pelo ID
	@GetMapping("/{Id}")
	public ResponseEntity<Product> findById(@PathVariable Long Id){
		Product obj = service.findById(Id);
		return ResponseEntity.ok().body(obj);
	}
	
	//DELETE
	//recebe no formato /products/id_produto e deleta o produto referente no BD
	@DeleteMapping("/{Id}")
	public ResponseEntity<Void> RemoveById(@PathVariable Long Id){
		service.Delete(Id);
		return ResponseEntity.noContent().build();
	}
	
	//UPDATE
	//recebe no formato /products/id_produto/id_categoria/descricao e atualiza o produto referente ao id no BD
	@PutMapping("/{Id}/{id_categoria}/{descricao}")
	public ResponseEntity<Product> update(@PathVariable Long Id, @PathVariable Long id_categoria, @PathVariable String descricao){
		Product obj = new Product();
		obj.setId(Id);
		obj.setId_categoria(id_categoria);
		obj.setDescricao(descricao);
		service.update(Id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	//INSERT
	@PostMapping("/{id_categoria}/{descricao}")
	public ResponseEntity<Product> insert(@PathVariable Long id_categoria, @PathVariable String descricao){
		Product obj = new Product();
		obj.setId_categoria(id_categoria);
		obj.setDescricao(descricao);
		service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
