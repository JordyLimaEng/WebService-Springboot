package com.jordy.projetoweb.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jordy.projetoweb.entities.User;
import com.jordy.projetoweb.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping // especifica que vai responder uma requisição GET em /users
	public ResponseEntity<List<User>> findAll() {// resonde uma lista de user
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);// responde lista - via http ok
	}

	@GetMapping(value = "/{Id}")
	public ResponseEntity<User> findById(@PathVariable Long Id) {// @PathVariable é usado para dizer que vai receber o
																	// id via url
		User obj = service.findById(Id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping // especifica que vai responder uma requisição POST
	public ResponseEntity<User> insert(@RequestBody User obj) {//resquest body é usado aqui para 'desserializar' oq tem recebido
		obj = service.insert(obj);
		//created é utilizado aqui pois ao criar um novo resource o padrão é retornar um 201
		//mas, é necessário um cabeçalho indicando o endereço do recurso criado (URI).
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();//já chama o código 204 que n tem conteúdo de reposta e ja trata.
	}
	
	@PutMapping(value = "/{id}")// no HTTP usa-se put para dar um update
	public ResponseEntity<User> update(@PathVariable Long id,@RequestBody User obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
