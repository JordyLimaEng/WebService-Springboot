package com.jordy.projetoweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jordy.projetoweb.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
