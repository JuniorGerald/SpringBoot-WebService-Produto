package com.educando.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educando.course.entities.Category;
import com.educando.course.entities.User;
import com.educando.course.repositories.CategoryRepository;
import com.educando.course.repositories.UserRepository;

@Service
public class CategoryServices {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	
	public Category findById(Long id){
		Optional<Category> obj =  repository.findById(id);
		return obj.get();
	}
	
	

}
