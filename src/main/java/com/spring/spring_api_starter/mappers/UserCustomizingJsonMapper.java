package com.spring.spring_api_starter.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.spring.spring_api_starter.dto.UserCustomizingJson;
import com.spring.spring_api_starter.entity.User;

@Mapper(componentModel = "spring")
public interface UserCustomizingJsonMapper {
	@Mapping(target = "currentDateTime", expression = "java(java.time.LocalDateTime.now())")
	UserCustomizingJson toUserCustomizingJson(User user);
}
