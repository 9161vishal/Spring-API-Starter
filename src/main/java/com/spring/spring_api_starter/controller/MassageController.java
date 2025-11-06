package com.spring.spring_api_starter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring_api_starter.entity.Massage;

@RestController
public class MassageController {
	
	@RequestMapping("/massage")
	public String massages() {
		return "Hey How Are You....";
	}
	
	@RequestMapping("/massageObj")
	public Massage massagesObj() {
		return new Massage("Hii massage object..");
	}
}
