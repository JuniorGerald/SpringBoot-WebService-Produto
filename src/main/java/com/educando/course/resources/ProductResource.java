package com.educando.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educando.course.entities.Product;
import com.educando.course.services.ProductServices;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
		
		@Autowired
		private ProductServices service;
		
		//busca todos os registros
		@GetMapping
		public ResponseEntity<List<Product>> findAll(){
			//Product u = new Product(1L, "Maria", "@gmail", "123455", "12345");
			List<Product> list = service.findAll();
			return ResponseEntity.ok().body(list);
		}
		
		//buscar por ID
		@GetMapping(value = "/{id}")// a requisição precisará de um ID
		public ResponseEntity<Product> findById(@PathVariable Long id){
			//Product u = new Product(1L, "Maria", "@gmail", "123455", "12345");
			Product obj = service.findById(id);
			return ResponseEntity.ok().body(obj);
		}
}
