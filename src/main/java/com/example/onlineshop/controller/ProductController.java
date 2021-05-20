package com.example.onlineshop.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlineshop.dto.ProductDto;
import com.example.onlineshop.dto.ProductMapper;
import com.example.onlineshop.exception.InvalidProductException;
import com.example.onlineshop.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
public class ProductController {
	Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	/**
	 * Gets a list of available products from warehouse
	 * 
	 * @return
	 */
	@GetMapping(value = "/product/getAll", produces = { "application/json" })
	@ApiOperation(value = "Gets a list of available products from warehouse", response = ResponseEntity.class)
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No products available."),
			@ApiResponse(code = 200, message = "Products successfully retrieved.") })
	private ResponseEntity<List<ProductDto>> getAllProducts() {
		logger.info("Method getAllProducts called");
		try {
			List<ProductDto> products = ProductMapper.toDtoList(productService.getAllProducts());
			if (products.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(products, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Saves a new product to warehouse
	 * 
	 * @param product to be saved to warehouse
	 * @return
	 */
	@PostMapping(value = "/product")
	@ApiOperation(value = "Saves a new product to warehouse", response = ResponseEntity.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Product successfully saved."),
			@ApiResponse(code = 400, message = "Product is not valid.") })
	private ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto product) {
		logger.info("Method saveProduct called");
		try {
			ProductDto p = ProductMapper.toDto(productService.saveProduct(ProductMapper.toEntity(product)));
			return new ResponseEntity<>(p, HttpStatus.CREATED);

		} catch (InvalidProductException ex) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
