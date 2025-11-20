package com.spring.spring_api_starter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.spring_api_starter.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByCategoryId(Byte categoryId);
}
