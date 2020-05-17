package com.jordy.projetoweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jordy.projetoweb.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
