package com.educando.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educando.course.entities.Order;
import com.educando.course.entities.User;
import com.educando.course.repositories.OrderRepository;
import com.educando.course.repositories.UserRepository;

@Service
public class OrderServices {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	
	public Order findById(Long id){
		Optional<Order> obj =  repository.findById(id);
		return obj.get();
	}
	
	

}
