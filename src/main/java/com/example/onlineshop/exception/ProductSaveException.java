package com.example.onlineshop.exception;

public class ProductSaveException extends RuntimeException {

    public ProductSaveException() {
        super();
    }

    public ProductSaveException(String message) {
        super(message);
    }

    public ProductSaveException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductSaveException(Throwable cause) {
        super(cause);
    }
}