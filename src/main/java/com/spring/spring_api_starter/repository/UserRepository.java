package com.spring.spring_api_starter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.spring_api_starter.dto.UserDto;
import com.spring.spring_api_starter.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	List<UserDto> findAllProjectedBy();
}
