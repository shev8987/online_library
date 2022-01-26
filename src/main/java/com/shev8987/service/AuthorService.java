package com.shev8987.service;

import com.shev8987.entity.Author;
import com.shev8987.repository.IAuthorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {

    IAuthorRepository authorRepository;

    public ResponseEntity<Author> GetAuthor(Long id) {

        Optional<Author> author = authorRepository.findById(id);

        return new ResponseEntity<>(author.get(), HttpStatus.OK);
    }

}
