package com.example.onlineshop.dao;

import java.util.List;

import com.example.onlineshop.entity.ProductEntity;

public interface ProductDao {

	List<ProductEntity> getAllProducts();

	ProductEntity saveProduct(ProductEntity product);

}
