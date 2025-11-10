package com.spring.spring_api_starter.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spring.spring_api_starter.dto.UserDto;
import com.spring.spring_api_starter.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{
	List<UserDto> findAllProjectedBy();
}
