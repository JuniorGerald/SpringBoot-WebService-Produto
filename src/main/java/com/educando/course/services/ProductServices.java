package com.educando.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educando.course.entities.Product;
import com.educando.course.entities.User;
import com.educando.course.repositories.ProductRepository;
import com.educando.course.repositories.UserRepository;

@Service
public class ProductServices {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	
	public Product findById(Long id){
		Optional<Product> obj =  repository.findById(id);
		return obj.get();
	}
	
	

}
