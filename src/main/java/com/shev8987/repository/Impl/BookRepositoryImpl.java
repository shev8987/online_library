package com.shev8987.repository.Impl;

import com.shev8987.model.BookDto;
import com.shev8987.repository.IBookRepository;

import java.util.List;

public class BookRepositoryImpl implements IBookRepository {
    @Override
    public BookDto GetBook(int id) {
        return null;
    }

    @Override
    public BookDto GetBook(String name) {
        return null;
    }

    @Override
    public List<BookDto> GetBooksToTitle(String title) {
        return null;
    }

    @Override
    public List<BookDto> GetBooksToAuthor(String author) {
        return null;
    }

    @Override
    public List<BookDto> GetBooksToGenre(String genre) {
        return null;
    }

    @Override
    public void SaveBook(BookDto book) {

    }

    @Override
    public void DeleteBook(Integer id) {

    }
}
