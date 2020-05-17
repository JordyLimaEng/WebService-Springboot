package com.jordy.projetoweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jordy.projetoweb.entities.User;
import com.jordy.projetoweb.repositories.UserRepository;
import com.jordy.projetoweb.services.exceptions.ResourceNotFoundException.ResourceNotFoundException;

@Service// registra a classe como um serviço
public class UserService {//camada de serviço
	
	@Autowired
	private	UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long Id){
		Optional<User> obj = repository.findById(Id);// vai imediatamente no banco de dados e trás o 
		return obj.orElseThrow(()->new ResourceNotFoundException(Id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getOne(id);// instancia um usuario, mas nao vai no jpa, trabalha e dps envia 
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {//nem todos é bom deixar alterar, como a senha...
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
