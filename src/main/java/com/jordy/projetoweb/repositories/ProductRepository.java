package com.jordy.projetoweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jordy.projetoweb.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
