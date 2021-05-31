package com.credibanco.assessment.library.services;

import java.util.List;

import com.credibanco.assessment.library.models.Book;

public interface IBookService {

	public List<Book> findAll();

	public Book findById(Long id);
	
	public Book save(Book book) throws Exception;
}
