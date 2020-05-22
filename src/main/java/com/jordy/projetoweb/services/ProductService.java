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
	
	//SELECT all
	//através dos annotations do hibernate e as interface faz um mapeamento do banco de dados e retorna todos os produtos cadastrados.
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	//faz uma requisição ao banco de dados em memória de acordo com o ID e retorna o produto como resposta	
	public Product findById(Long Id){
		Optional<Product> obj = repository.findById(Id);
		return obj.get();
	}
	
	//deleta o produto correspondente ao ID do banco de dados
	public void Delete(Long Id){
		repository.deleteById(Id);
	}
	
	//atualiza o s campos descrição e id_catergoria na tabela do banco de dados
	public Product update(Long id, Product obj) {
		Product entity = repository.getOne(id);
		entity.setDescricao(obj.getDescricao());
		entity.setId_categoria(obj.getId_categoria());
		return repository.save(entity);
	}
	
	//insere um novo objeto de Produto na tabela de produtos no banco de dados
	public Product insert(Product obj) {
		return repository.save(obj);
	}
}
