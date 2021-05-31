package com.credibanco.assessment.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.credibanco.assessment.library.dao.IAuthorDao;
import com.credibanco.assessment.library.dao.IBookDao;
import com.credibanco.assessment.library.dao.IEditorialDao;
import com.credibanco.assessment.library.exceptions.AuthorNotFoundException;
import com.credibanco.assessment.library.exceptions.BookLimitException;
import com.credibanco.assessment.library.exceptions.EditorialNotFoundException;
import com.credibanco.assessment.library.models.Book;
import com.credibanco.assessment.library.services.IBookService;

@Service
public class BookServiceImpl implements IBookService{

	@Autowired
	IBookDao bookDao;
	
	@Autowired
	AuthorServiceImpl authorService;
	
	@Autowired
	EditorialServiceImpl editorialService;
	
	@Override
	@Transactional(readOnly = true)
	public List<Book> findAll() {
		return (List<Book>) bookDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Book findById(Long id) {
		return bookDao.findById(id).orElseThrow();
	}

	@Override
	@Transactional
	public Book save(Book book) throws Exception{
		
			authorService.findAll().stream().filter(author -> author.getName().equals(book.getAuthor())).findFirst().orElseThrow(AuthorNotFoundException::new);
			editorialService.findAll().stream().filter(editorial -> editorial.getName().equals(book.getEditorial())).findFirst().orElseThrow(EditorialNotFoundException::new);
			long bookLimit = editorialService.findAll().stream().filter(editorial -> editorial.getName().equals(book.getEditorial())).findFirst().get().getBooksLimit();
			long booksRegistered = findAll().stream().filter(registerBook -> registerBook.getEditorial().equals(book.getEditorial())).count();
			if (bookLimit == booksRegistered) throw new BookLimitException();
			return bookDao.save(book);
		
	}
	
}
