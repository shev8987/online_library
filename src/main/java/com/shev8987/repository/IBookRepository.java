package com.shev8987.repository;

import com.shev8987.entity.BookEntity;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IBookRepository extends CrudRepository<BookEntity, Long> {

    List<BookEntity> findAllByTitleContaining(String title);

    List<BookEntity> findAllByAuthorId(Long id);

    List<BookEntity> findAllByGenreId(Long id);

}
