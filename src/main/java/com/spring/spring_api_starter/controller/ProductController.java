package com.spring.spring_api_starter.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring_api_starter.dto.ProductDto;
import com.spring.spring_api_starter.entity.Product;
import com.spring.spring_api_starter.mappers.ProductMapper;
import com.spring.spring_api_starter.repository.ProductRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
	final private ProductRepository productRepository;
	final private ProductMapper productMapper;
	
//	@GetMapping
//	public Iterable<Product> findAllProducts(){//---------> This API cause JSON cyclic problem
//		return productRepository.findAll();
//	}

// THIS API RETURNS ALL PRODUCTS AND CATEGORY ID IS OPTION QUERY PARAMETER
	@GetMapping
	public List<ProductDto> getAllProduct(@RequestParam(required = false, name="categoryId") Byte categoryId){
		List<Product> products;
		if(categoryId!=null) {
			products=productRepository.findByCategoryId(categoryId);
		}
		else {
			products= productRepository.findAll();
		}
		return products.stream()
				.map(productMapper::toProductDto)
				.toList();
	}

// THIS API RETURNS A SINGLE PRODUCT BY PRODUCT ID
	@GetMapping("/product/{id}")
	public ResponseEntity<ProductDto> findProductByProductId(@PathVariable Long id) {
		Product product=productRepository.findById(id).orElse(null);
		ProductDto productDto=productMapper.toProductDto(product);
		if(product==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(productDto);
	}
}
