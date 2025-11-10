package com.spring.spring_api_starter.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring_api_starter.dto.UserDto;
import com.spring.spring_api_starter.entity.User;
import com.spring.spring_api_starter.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	final private UserRepository userRepository;
	
//  JUST A SIMPLE RESTFUL API TO RETURN ALL USERS JSON OBJECTS
	@GetMapping
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

//  THISW API RETURNS THE DTO JSON OBJECT OF USER
	@GetMapping("/dto")
	public List<UserDto> getUsersDto() {
		return userRepository.findAllProjectedBy();
	}

//CREATING DYNAMIC ROUTES WHICH RETURN DATA BASED ON SOME INPUT LIKE USER ID
	@GetMapping("/{id}")
	public User findUserById(@PathVariable Long id){
		return userRepository.findById(id).orElse(null);
	}
	
//CREATING A RESPONSE ENTITY FOR GENERATING A CUSTOMISE STATUS FOR IS RECORD IS NOT PRESENT
	@GetMapping("/modified/{id}")
	public ResponseEntity<User> getUsersByIdWithAppropreiteStatusCode(@PathVariable Long id){
		User user = userRepository.findById(id).orElse(null);
		if(user==null) {
			//return new ResponseEntity<>(HttpStatus.NOT_FOUND); //-----> normal way create Response Status
			return ResponseEntity.notFound().build();//-----> Also follow Builder pattern
		}
		//return new ResponseEntity<User>(user, HttpStatus.OK); //-------> normal way to return response Status with body
		return ResponseEntity.ok(user); //-------> Using Builder pattern 
	}
}
