package com.credibanco.assessment.library.dao;

import org.springframework.data.repository.CrudRepository;

import com.credibanco.assessment.library.models.Author;

public interface IAuthorDao extends CrudRepository<Author, Long> {

}
