package com.credibanco.assessment.library.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.library.models.Author;
import com.credibanco.assessment.library.models.Book;
import com.credibanco.assessment.library.models.Editorial;
import com.credibanco.assessment.library.services.IAuthorService;
import com.credibanco.assessment.library.services.IBookService;
import com.credibanco.assessment.library.services.IEditorialService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClientRestController {

	@Autowired
	IAuthorService authorService;
	
	@Autowired
	IBookService bookService;
	
	@Autowired
	IEditorialService editorialService;
	
	@GetMapping("/authors")
	public List<Author> index() {
		return authorService.findAll();
	}
	
	@GetMapping("/authors/{id}")
	public Author show(@PathVariable Long id) {
		return authorService.findById(id);
	}
	
	@PostMapping("/authors")
	@ResponseStatus(HttpStatus.CREATED)
	public Author create(@RequestBody Author author) {
		return authorService.save(author);
	}
	
	@GetMapping("/books")
	public List<Book> indexBooks() {
		return bookService.findAll();
	}
	
	@GetMapping("/books/{id}")
	public Book showBook(@PathVariable Long id) {
		return bookService.findById(id);
	}
	
	@PostMapping("/books")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> createBook(@RequestBody Book book) throws Exception {
		Book newBook = null;
		Map<String, Object> response = new HashMap<>();
		try {
			newBook = bookService.save(book); 
		} catch (Exception e) {
			response.put("mensaje", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Book>(newBook, HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/editorials")
	public List<Editorial> indexEditorials() {
		return editorialService.findAll();
	}
	
	@GetMapping("/editorials/{id}")
	public Editorial showEditorial(@PathVariable Long id) {
		return editorialService.findById(id);
	}
	
	@PostMapping("/editorials")
	@ResponseStatus(HttpStatus.CREATED)
	public Editorial createEditorial(@RequestBody Editorial editorial) {
		return editorialService.save(editorial);
	}
}
