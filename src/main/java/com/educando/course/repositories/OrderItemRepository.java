package com.educando.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educando.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	

}
