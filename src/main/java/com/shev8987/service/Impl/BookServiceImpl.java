package com.shev8987.service.Impl;

import com.shev8987.model.BookDto;
import com.shev8987.service.IBookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Override
    public void AddBook(BookDto bookDto) {

    }

    @Override
    public List<BookDto> GetAllBooks() {
        return null;
    }

    @Override
    public BookDto GetBook(int id) {
        return null;
    }

    @Override
    public boolean UpdateBook(int id) {
        return false;
    }

    @Override
    public boolean Delete(int id) {
        return false;
    }
}
