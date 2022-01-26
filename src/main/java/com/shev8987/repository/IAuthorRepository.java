package com.shev8987.repository;

import com.shev8987.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface IAuthorRepository  extends CrudRepository<Author, Long> {

}
