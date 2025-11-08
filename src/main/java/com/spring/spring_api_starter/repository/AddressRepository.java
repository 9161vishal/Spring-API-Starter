package com.spring.spring_api_starter.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.spring_api_starter.entity.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
