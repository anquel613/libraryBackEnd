package com.credibanco.assessment.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.dao.IEditorialDao;
import com.credibanco.assessment.library.models.Editorial;
import com.credibanco.assessment.library.services.IEditorialService;

@Service
public class EditorialServiceImpl implements IEditorialService{

	@Autowired
	IEditorialDao editorialDao;
	
	
	@Override
	public List<Editorial> findAll() {
		return (List<Editorial>) editorialDao.findAll();
	}


	@Override
	public Editorial findById(Long id) {
		return editorialDao.findById(id).orElseThrow();
	}


	@Override
	public Editorial save(Editorial editorial) {
		return editorialDao.save(editorial);
	}
	
}
