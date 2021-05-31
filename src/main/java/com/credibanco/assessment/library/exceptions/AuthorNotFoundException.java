package com.credibanco.assessment.library.exceptions;

public class AuthorNotFoundException extends Exception{


	public AuthorNotFoundException() {
		super("El autor no está registrado");
		// TODO Auto-generated constructor stub
	}

	public AuthorNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public AuthorNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AuthorNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
}
