package com.educando.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educando.course.entities.Category;
import com.educando.course.services.CategoryServices;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
		
		@Autowired
		private CategoryServices service;
		
		//busca todos os registros
		@GetMapping
		public ResponseEntity<List<Category>> findAll(){
			//Category u = new Category(1L, "Maria", "@gmail", "123455", "12345");
			List<Category> list = service.findAll();
			return ResponseEntity.ok().body(list);
		}
		
		//buscar por ID
		@GetMapping(value = "/{id}")// a requisição precisará de um ID
		public ResponseEntity<Category> findById(@PathVariable Long id){
			//Category u = new Category(1L, "Maria", "@gmail", "123455", "12345");
			Category obj = service.findById(id);
			return ResponseEntity.ok().body(obj);
		}
}
