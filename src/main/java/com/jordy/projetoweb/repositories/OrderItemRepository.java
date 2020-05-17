package com.jordy.projetoweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jordy.projetoweb.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
}
