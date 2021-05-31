package com.credibanco.assessment.library.services;

import java.util.List;

import com.credibanco.assessment.library.models.Editorial;

public interface IEditorialService {
	public List<Editorial> findAll();
	
	public Editorial findById(Long id);
	
	public Editorial save(Editorial editorial);
}
