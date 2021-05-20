package com.example.onlineshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.onlineshop.entity.ProductEntity;

@Repository
public class ProductDaoImpl implements ProductDao {
	Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<ProductEntity> getAllProducts() {
		logger.info("Method getAllProducts called");
		TypedQuery<ProductEntity> query = entityManager.createQuery("from ProductEntity", ProductEntity.class);
		return query.getResultList();

	}

	@Override
	public ProductEntity saveProduct(ProductEntity product) {
		logger.info("Method saveProduct called");
		logger.info("Saving product with code: " + product.getCode());
		entityManager.persist(product);
		logger.info("Saved product with code: " + product.getCode());
		return product;
	}

}
