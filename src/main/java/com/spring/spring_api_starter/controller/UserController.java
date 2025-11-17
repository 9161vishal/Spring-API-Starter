package com.spring.spring_api_starter.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring_api_starter.dto.UserCustomizingJson;
import com.spring.spring_api_starter.dto.UserDto;
import com.spring.spring_api_starter.dto.UserSummary;
import com.spring.spring_api_starter.entity.User;
import com.spring.spring_api_starter.mappers.UserCustomizingJsonMapper;
import com.spring.spring_api_starter.mappers.UserMapper;
import com.spring.spring_api_starter.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	final private UserRepository userRepository;
	@Autowired
    private UserMapper userMapper;
	
	final private UserCustomizingJsonMapper userCustomizingJsonMapper;
	


	//  JUST A SIMPLE RESTFUL API TO RETURN ALL USERS JSON OBJECTS
	@GetMapping
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}


//CREATING DYNAMIC ROUTES WHICH RETURN DATA BASED ON SOME INPUT LIKE USER ID
	@GetMapping("/{id}")
	public User findUserById(@PathVariable Long id){
		return userRepository.findById(id).orElse(null);
	}
	
//CREATING A RESPONSE ENTITY FOR GENERATING A CUSTOMISE STATUS FOR IS RECORD IS NOT PRESENT
	@GetMapping("/addstatus/{id}")
	public ResponseEntity<User> getUsersByIdWithAppropreiteStatusCode(@PathVariable Long id){
		User user = userRepository.findById(id).orElse(null);
		if(user==null) {
			//return new ResponseEntity<>(HttpStatus.NOT_FOUND); //-----> normal way create Response Status
			return ResponseEntity.notFound().build();//-----> Also follow Builder pattern
		}
		//return new ResponseEntity<User>(user, HttpStatus.OK); //-------> normal way to return response Status with body
		return ResponseEntity.ok(user); //-------> Using Builder pattern 
	}
	
	
//  THIS API RETURNS THE DTO JSON OBJECT OF USER ----->1. BY USING INTERFACES AND CUSTOMQUERY METHODS
	@GetMapping("/dto")
	public List<UserDto> getUsersDto() {
		return userRepository.findAllProjectedBy();//-----> this custom query method is defined in UserRepository
	}
	
//  THIS API RETURNS THE DTO JSON OBJECT OF USER ----->2. BY USING DTO CLASS AND MAPPING USER TO USERDTO(JAVA 8)
	@GetMapping("/dto/class")
	public List<UserSummary> getUsersSummaryClass() {
		return userRepository.findAll().stream()
				.map(user->new UserSummary(user.getId(), user.getName(), user.getEmail()))
				.toList();
	}

//    THIS API RETURNS THE DTO JSON OBJECT OF USER -----3. BY USING MAPSTRUCT
	@GetMapping("/dto/usermapper")// -----> just simple way
	public List<UserSummary> getUserSummariesByUsingMapStruct(){
		return userRepository.findAll().stream()
				.map(userMapper::toUserDto)
				.toList();
	}
	
	@RequestMapping("/dto/usermapper/{id}")// ------> With Response Entity Based on id as an input
	public ResponseEntity<UserSummary> getUserSummryInResponseEntityWithMapStruct(@PathVariable Long id){
		User users=userRepository.findById(id).orElse(null);
		
		if(users==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(userMapper.toUserDto(users));
	}

//   THIS API RETURNS CUSTOMIZE JASON OBJECT
	@GetMapping("/dto/usercustomizingjson")
	public List<UserCustomizingJson> getUserCustomizingJsons(){
		return userRepository.findAll().stream()
				.map(userCustomizingJsonMapper::toUserCustomizingJson)
				.toList();
	}
}
