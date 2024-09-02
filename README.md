# Online Shop

## Overview

The Online Shop project is a Spring Boot application designed for managing products in a warehouse. It provides RESTful APIs for product management, including endpoints to retrieve and create products. The project uses an H2 database for persistence and generates API documentation using OpenAPI.

## Features

- **Retrieve all products**: Get a list of all products in the warehouse.
- **Create a new product**: Add a new product to the warehouse.

## REST API Best Practices

Here are some best practices followed in this project:

### 1. Use Nouns for Resource URIs

- **Good**: `/products`, `/products/{id}`
- **Bad**: `/getAllProducts`, `/saveProduct`

Resources are identified by nouns (e.g., `products`), not verbs.

### 2. Use HTTP Methods Correctly

- **GET**: Retrieve resource(s) (e.g., `/products`)
- **POST**: Create a new resource (e.g., `/products`)
- **PUT**: Update an existing resource (e.g., `/products/{id}`)
- **DELETE**: Delete a resource (e.g., `/products/{id}`)

### 3. Implement Proper Status Codes

- **200 OK**: Successful GET request
- **201 Created**: Successful POST request that creates a resource
- **204 No Content**: Successful request with no content (e.g., DELETE)
- **400 Bad Request**: Invalid input
- **404 Not Found**: Resource not found
- **500 Internal Server Error**: Unexpected server error

### 4. Use Consistent Naming Conventions

- Resource names should be plural (e.g., `products`).
- Use lowercase and hyphens for readability (e.g., `/products/{product-id}`).

### 5. Provide Meaningful Error Messages

- Include details in error messages to help users understand what went wrong (e.g., "Invalid product data").

### 6. Support Filtering, Sorting, and Pagination

- **Filtering**: Allow clients to filter resources (e.g., `/products?category=electronics`).
- **Sorting**: Allow clients to sort resources (e.g., `/products?sort=name,asc`).
- **Pagination**: Provide paginated results (e.g., `/products?page=1&size=20`).
