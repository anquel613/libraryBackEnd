package com.credibanco.assessment.library.services;

import java.util.List;

import com.credibanco.assessment.library.models.Author;

public interface IAuthorService {

	public List<Author> findAll();
	
	public Author findById(Long id);
	
	public Author save(Author author);
	
	public void delete(Long id);
	
}
