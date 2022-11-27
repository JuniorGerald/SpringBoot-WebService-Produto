package com.educando.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educando.course.entities.User;
import com.educando.course.services.UserServices;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
		
		@Autowired
		private UserServices service;
		
		//busca todos os registros
		@GetMapping
		public ResponseEntity<List<User>> findAll(){
			//User u = new User(1L, "Maria", "@gmail", "123455", "12345");
			List<User> list = service.findAll();
			return ResponseEntity.ok().body(list);
		}
		
		//buscar por ID
		@GetMapping(value = "/{id}")// a requisição precisará de um ID
		public ResponseEntity<User> findById(@PathVariable Long id){
			//User u = new User(1L, "Maria", "@gmail", "123455", "12345");
			User obj = service.findById(id);
			return ResponseEntity.ok().body(obj);
		}
		
		@PostMapping //insere
		public ResponseEntity<User> insert(@RequestBody User obj){ // faz retornar o 201 que significa que criou um recurso
			obj  = service.insert(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).body(obj);
			
			
		}
		
		@DeleteMapping(value = "/{id}")
		public ResponseEntity<Void> delete(@PathVariable Long id){
			service.delete(id);
			return ResponseEntity.noContent().build();
		}
		
		@PutMapping(value = "/{id}")
		public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
			obj = service.update(id, obj);
			return ResponseEntity.ok().body(obj);
		}
		
		
		
		
}
