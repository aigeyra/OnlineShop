package com.example.onlineshop.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.onlineshop.dao.ProductDao;
import com.example.onlineshop.entity.ProductEntity;

@Service
public class ProductServiceImpl implements ProductService {
	Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	ProductDao productDao;

	@Override
	public List<ProductEntity> getAllProducts() {
		logger.info("Method getAllProducts called");
		return productDao.getAllProducts();
	}

	@Override
	@Transactional
	public ProductEntity saveProduct(ProductEntity product) {
		logger.info("Method saveProduct called");
		return productDao.saveProduct(product);
	}

}
