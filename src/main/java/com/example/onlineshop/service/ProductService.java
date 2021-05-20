package com.example.onlineshop.service;

import java.util.List;

import com.example.onlineshop.entity.ProductEntity;

public interface ProductService {

	ProductEntity saveProduct(ProductEntity product);

	List<ProductEntity> getAllProducts();

}
