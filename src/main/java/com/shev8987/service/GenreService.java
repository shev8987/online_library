package com.shev8987.service;

import com.shev8987.entity.Genre;
import com.shev8987.repository.IGenreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenreService {

    IGenreRepository genreRepository;

    public ResponseEntity<Genre> GetGenre(Long id) {

        Optional<Genre> genre = genreRepository.findById(id);

        return new ResponseEntity<>(genre.get(), HttpStatus.OK);

    }
}
