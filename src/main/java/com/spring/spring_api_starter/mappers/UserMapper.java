package com.spring.spring_api_starter.mappers;


import org.mapstruct.Mapper;

import com.spring.spring_api_starter.dto.UserSummary;
import com.spring.spring_api_starter.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	UserSummary toUserDto(User user);
}