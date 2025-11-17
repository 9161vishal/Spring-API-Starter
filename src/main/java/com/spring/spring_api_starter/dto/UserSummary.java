package com.spring.spring_api_starter.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;



@AllArgsConstructor
@Getter
public class UserSummary {
	private Long id;
	private String name;
	private String email;
	
}
