package com.springTeste.userDept.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springTeste.userDept.entities.User;
import com.springTeste.userDept.repositories.UserRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;



@RestController
@RequestMapping(value  = "/users")
public class UserControler {
	@Autowired
	private UserRepository repository; 
	
	@Operation(description = "Busca os users")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200",description = "retorna o user"),
	@ApiResponse(responseCode = "400",description = "nao existe o user")
	})
	@GetMapping
	public List<User> findAll(){
		List <User> result = repository.findAll();
		return result;
	}
	
	@Operation(description = "Busca o user pelo id")
	@GetMapping(value = "{id}")
	public User findbyId(@PathVariable Long id){
		User result = repository.findById(id).get();
		return result;
	}
	
	@Operation(description = "Salva o user pelo id")
	@PostMapping(value = "{id}")
	public User insert(@RequestBody User user){
		User result = repository.save(user);
		return result;
	}
	
	
	
}
