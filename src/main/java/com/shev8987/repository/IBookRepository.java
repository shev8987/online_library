package com.shev8987.repository;

import com.shev8987.entity.Book;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IBookRepository extends CrudRepository<Book, Long> {

    List<Book> findAllByTitleContaining(String title);

    List<Book> findAllByAuthorId(Long id);

    List<Book> findAllByGenreId(Long id);

}
