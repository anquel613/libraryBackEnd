package com.credibanco.assessment.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.credibanco.assessment.library.dao.IAuthorDao;
import com.credibanco.assessment.library.models.Author;
import com.credibanco.assessment.library.services.IAuthorService;

@Service
public class AuthorServiceImpl implements IAuthorService{

	@Autowired
	IAuthorDao clientDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Author> findAll() {
		return (List<Author>) clientDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Author findById(Long id) {
		return clientDao.findById(id).orElseThrow();
	}

	@Override
	@Transactional
	public Author save(Author author) {
		// TODO Auto-generated method stub
		return clientDao.save(author);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clientDao.deleteById(id);
		
	}


}
