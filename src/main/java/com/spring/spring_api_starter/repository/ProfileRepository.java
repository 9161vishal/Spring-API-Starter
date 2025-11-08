package com.spring.spring_api_starter.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.spring_api_starter.entity.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

}
