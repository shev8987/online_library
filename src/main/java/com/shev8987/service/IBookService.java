package com.shev8987.service;

import com.shev8987.model.BookDto;

import java.util.List;

public interface IBookService {

    /*
     * Добавляет новую книгу
     * */
    void AddBook(BookDto bookDto);

    /*
     * Возвращает список книг
     * */
    List<BookDto> GetAllBooks();

    /*
     * Возвращает книгу с заданным ID
     * */
    BookDto GetBook(int id);

    /*
     * Обновляет книгу с заданным ID
     * */
    boolean UpdateBook(int id);

    /*
     * Удаляет книгу с заданным ID
     * */
    boolean Delete(int id);


}
