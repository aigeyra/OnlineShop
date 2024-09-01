package com.example.onlineshop.controller;

import com.example.onlineshop.dto.ProductDto;
import com.example.onlineshop.dto.ProductMapper;
import com.example.onlineshop.entity.ProductEntity;
import com.example.onlineshop.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product Management", description = "APIs for managing products")
public class ProductController {
	private final ProductService productService;
	private final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	@Operation(summary = "Get all products", description = "Retrieve a list of all products")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful retrieval of products"),
			@ApiResponse(responseCode = "204", description = "No products found")
	})
	public ResponseEntity<List<ProductDto>> getAllProducts() {
		logger.info("Received request to get all products");
		List<ProductEntity> productEntities = productService.getAllProducts();
		List<ProductDto> products = productEntities.stream()
				.map(ProductMapper::toDto)
				.collect(Collectors.toList());
		if (products.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@PostMapping
	@Operation(summary = "Save a new product", description = "Create a new product")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Product successfully created"),
			@ApiResponse(responseCode = "400", description = "Invalid product data")
	})
	public ResponseEntity<ProductDto> saveProduct(
			@Parameter(description = "Product details to be created") @Valid @RequestBody ProductDto product) {
		logger.info("Received request to save product: {}", product.getName());
		ProductEntity productEntity = ProductMapper.toEntity(product);
		ProductEntity savedEntity = productService.saveProduct(productEntity);
		ProductDto savedProduct = ProductMapper.toDto(savedEntity);
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}
}