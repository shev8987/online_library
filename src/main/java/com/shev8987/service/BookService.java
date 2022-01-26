package com.shev8987.service;

import com.shev8987.entity.Book;
import com.shev8987.repository.IBookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final IBookRepository bookRepository;

    public BookService(IBookRepository repository) {
        this.bookRepository = repository;
    }

    public ResponseEntity<List<Book>> GetBooks() {

        return new ResponseEntity<>((List<Book>) bookRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Book> GetBook(Long id) {

        Optional<Book> book = bookRepository.findById(id);
            return new ResponseEntity<>(book.get(), HttpStatus.OK);
    }

    public ResponseEntity<Book> SaveBook(Book bookDto) throws ServerException {

        var book = bookRepository.save(bookDto);

        if (book == null) {

            throw new ServerException("Ошибка при добавлении/изменении книги");

        } else {

            return new ResponseEntity<>(book, HttpStatus.CREATED);
        }
    }

    public void Delete(Long id) {

        bookRepository.deleteById(id);
    }
}
