package com.educando.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educando.course.entities.Order;
import com.educando.course.services.OrderServices;

@RestController //controler com caracteristica REST
@RequestMapping(value = "/orders") //caminho para o acesso dessa regra
public class OrderResource {
		
		@Autowired //inicialização do objeto e injeção de dependência
		private OrderServices service;//Associação 
		
		//busca todos os registros
		@GetMapping
		public ResponseEntity<List<Order>> findAll(){
			//User u = new User(1L, "Maria", "@gmail", "123455", "12345");
			List<Order> list = service.findAll();
			return ResponseEntity.ok().body(list);
		}
		
		//buscar por ID
		@GetMapping(value = "/{id}")// a requisição precisará de um ID
		public ResponseEntity<Order> findById(@PathVariable Long id){
			//User u = new User(1L, "Maria", "@gmail", "123455", "12345");
			Order obj = service.findById(id);
			return ResponseEntity.ok().body(obj);
		}
}
