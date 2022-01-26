package com.shev8987.repository;

import com.shev8987.entity.Book;

import org.springframework.data.repository.CrudRepository;

public interface IBookRepository extends CrudRepository<Book, Long> {

}
