package com.credibanco.assessment.library.dao;

import org.springframework.data.repository.CrudRepository;

import com.credibanco.assessment.library.models.Book;

public interface IBookDao extends CrudRepository<Book, Long> {

}
