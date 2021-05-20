package com.example.onlineshop.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.onlineshop.entity.ProductEntity;

public class ProductMapper {

	public static ProductDto toDto(ProductEntity entity) {
		ProductDto dto = new ProductDto();
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setStock(entity.getStock());
		dto.setUnitPrice(entity.getUnitPrice());
		return dto;
	}

	public static List<ProductDto> toDtoList(List<ProductEntity> entities) {
		List<ProductDto> dtoList = new ArrayList<>();
		for (ProductEntity entity : entities) {
			dtoList.add(toDto(entity));
		}
		return dtoList;
	}

	public static ProductEntity toEntity(ProductDto dto) {
		ProductEntity entity = new ProductEntity();
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setStock(dto.getStock());
		entity.setUnitPrice(dto.getUnitPrice());
		return entity;
	}
}