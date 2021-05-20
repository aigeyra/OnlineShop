package com.example.onlineshop.exception;

public class InvalidProductException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidProductException(String exception) {
		super(exception);
	}
}
