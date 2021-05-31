package com.credibanco.assessment.library.exceptions;

public class BookLimitException extends Exception{

	public BookLimitException() {
		super("No es posible registrar el libro, se alcanzó el máximo permitido.");
	}
	

}
