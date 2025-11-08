package com.spring.spring_api_starter.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.spring_api_starter.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
