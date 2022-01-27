package com.shev8987.service;

import com.shev8987.entity.AuthorEntity;
import com.shev8987.entity.BookEntity;
import com.shev8987.entity.GenreEntity;
import com.shev8987.model.AuthorModel;
import com.shev8987.model.BookModel;
import com.shev8987.model.GenreModel;
import com.shev8987.repository.IAuthorRepository;
import com.shev8987.repository.IBookRepository;
import com.shev8987.repository.IGenreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final IBookRepository bookRepository;

    private final IAuthorRepository authorRepository;

    private final IGenreRepository genreRepository;

    public BookService(IBookRepository repository, IAuthorRepository authorRepository, IGenreRepository genreRepository) {
        this.bookRepository = repository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }

    public ResponseEntity<List<BookModel>> GetBooks() {

        var data = (List<BookEntity>) bookRepository.findAll();
        List<BookModel> list = new ArrayList<>();

        for (var d: data) {

            Optional<AuthorEntity> author = authorRepository.findById(d.getAuthorId());
            Optional<GenreEntity> genre = genreRepository.findById(d.getGenreId());

            BookModel bookModel = new BookModel();
            bookModel.setId(d.getId());
            bookModel.setTitle(d.getTitle());
            bookModel.setAuthor(new AuthorModel(author.get()));
            bookModel.setGenre(new GenreModel(genre.get()));

            list.add(bookModel);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    public ResponseEntity<BookModel> GetBook(Long id) {

        Optional<BookEntity> book = bookRepository.findById(id);
        var data = book.get();
        Optional<AuthorEntity> author = authorRepository.findById(data.getAuthorId());
        Optional<GenreEntity> genre = genreRepository.findById(data.getGenreId());

        BookModel bookModel = new BookModel();
        bookModel.setId(data.getId());
        bookModel.setTitle(data.getTitle());
        bookModel.setAuthor(new AuthorModel(author.get()));
        bookModel.setGenre(new GenreModel(genre.get()));

        return new ResponseEntity<>(bookModel, HttpStatus.OK);
    }

    public ResponseEntity<List<BookEntity>> GetBookByTitle(String title) {

        List<BookEntity> book = bookRepository.findAllByTitleContaining(title);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    public ResponseEntity<List<BookEntity>> GetBookByAuthor(Long id) {

        List<BookEntity> book = bookRepository.findAllByAuthorId(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    public ResponseEntity<List<BookEntity>> GetBookByGenre(Long id) {

        List<BookEntity> book = bookRepository.findAllByGenreId(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }



    public ResponseEntity<BookEntity> SaveBook(BookEntity bookDto) {

        var book = bookRepository.save(bookDto);

        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    public void Delete(Long id) {

        bookRepository.deleteById(id);
    }
}
