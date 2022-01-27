package com.shev8987.controller;

import com.shev8987.entity.BookEntity;
import com.shev8987.model.BookModel;
import com.shev8987.service.BookService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService service) {
        this.bookService = service;
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookModel>> GetBooks(){

        var books = bookService.GetBooks();

        return bookService.GetBooks();
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookModel> GetBook(@PathVariable Long id){

        return bookService.GetBook(id);
    }

    @GetMapping("/books/title")
    public ResponseEntity<List<BookEntity>> GetBooksTitle(@RequestParam String title){

        return bookService.GetBookByTitle(title);
    }

    @GetMapping("/books/author")
    public ResponseEntity<List<BookEntity>> GetBooksAuthor(@RequestParam Long id){

        return bookService.GetBookByAuthor(id);
    }

    @GetMapping("/books/genre")
    public ResponseEntity<List<BookEntity>> GetBooksGenre(@RequestParam Long id){

        return bookService.GetBookByGenre(id);
    }

    @PostMapping("/book/add")
    public void create(@RequestBody BookEntity book) {

        bookService.SaveBook(book);
    }

    @PutMapping("/book/update")
    public void update(@RequestBody BookEntity book) {

        bookService.SaveBook(book);
    }

    @DeleteMapping("book/delete")
    public void deleteBook(@RequestBody BookEntity book){

        bookService.Delete(book.getId());
    }

}
