package com.jordy.projetoweb.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jordy.projetoweb.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping//especifica que vai responder uma requisição GET em /users
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "maria", "m@gmail.com", "555555555", "1234123");
		return ResponseEntity.ok().body(u);//responde via http ok
	}
}
