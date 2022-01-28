package com.shev8987.repository;

import com.shev8987.entity.BookEntity;
import com.shev8987.mapper.BookRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    private final JdbcTemplate jdbcTemplate;

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public BookEntity getBook(long id) {
        BookEntity book = (BookEntity) jdbcTemplate.query("select * from online_lib.book where id = ?", new Object[] {id}, new BookRowMapper());
        return book;
    }

    public List<BookEntity> getBooks() {
        var teachers = jdbcTemplate.query("SELECT * FROM book", new BookRowMapper());
        return teachers;
    }
}
