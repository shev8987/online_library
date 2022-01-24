package com.shev8987.service;

import com.shev8987.model.BookDto;

import java.util.List;

public interface BookService {

    void AddBook(BookDto bookDto);

    List<BookDto> GetAllBooks();

    BookDto GetBook(int id);

    boolean UpdateBook(int id);

    boolean Delete(int id);


}
