package com.shev8987.repository;

import com.shev8987.model.BookDto;

import java.util.List;

public interface IBookRepository {

    BookDto GetBook(int id);

    BookDto GetBook(String name);

    List<BookDto> GetBooksToTitle(String title);

    List<BookDto> GetBooksToAuthor(String author);

    List<BookDto> GetBooksToGenre(String genre);

    void SaveBook(BookDto book);

    void DeleteBook(Integer id);
}
