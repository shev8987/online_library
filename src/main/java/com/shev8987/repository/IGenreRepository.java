package com.shev8987.repository;

import com.shev8987.entity.Genre;
import org.springframework.data.repository.CrudRepository;

public interface IGenreRepository extends CrudRepository<Genre, Long> {

}
