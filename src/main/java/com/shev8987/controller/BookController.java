package com.shev8987.controller;

import com.shev8987.entity.Book;
import com.shev8987.service.AuthorService;
import com.shev8987.service.BookService;

import com.shev8987.service.GenreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService service) {
        this.bookService = service;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> GetBooks(){

        return bookService.GetBooks();
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> GetBook(@PathVariable Long id){

        return bookService.GetBook(id);
    }

    @PostMapping("/book/add")
    public void create(@RequestBody Book book) throws ServerException {

        bookService.SaveBook(book);
    }

    @PutMapping("/book/update")
    public void update(@RequestBody Book book) throws ServerException {

        bookService.SaveBook(book);
    }

    @DeleteMapping("book/delete")
    public void deleteBook(@RequestBody Book book){

        bookService.Delete(book.getId());
    }

}
