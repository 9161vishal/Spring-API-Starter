package com.spring.spring_api_starter.dto;


import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserCustomizingJson {
	@JsonIgnore//----------> This field is get ignored in JSON object 
	private Long id;
	@JsonProperty("User Name")//------------>This is used for field renaming in our JOSN object this will displayed "User Name"
	private String name;//                    instead of "name" 
	private String email;
	@JsonInclude(value = Include.NON_NULL)//------> if this field contain null during JSON creation then this field will ignored
	private Integer phoneNumber;
	
	@JsonFormat(pattern = "dd-MM-YY HH:mm:ss")
	private LocalDateTime currentDateTime;
	
}
