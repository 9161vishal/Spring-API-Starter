package com.spring.spring_api_starter.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.spring.spring_api_starter.dto.ProductDto;
import com.spring.spring_api_starter.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	@Mapping(target = "categoryId",source = "category.id")
	ProductDto toProductDto(Product product);
}
