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

        var sql = "select * from online_lib.book where id = ?";
        BookEntity book = (BookEntity) jdbcTemplate.queryForObject(sql, new Object[] {id}, new BookRowMapper());
        return book;
    }

    public List<BookEntity> getBooks() {
        var books = jdbcTemplate.query("SELECT * FROM book", new BookRowMapper());
        return books;
    }

    public List<BookEntity> getBooksByTitle(String title) {

        var sql = "SELECT * \n" +
                "FROM online_lib.book\n" +
                "WHERE title like ?";
        var books = jdbcTemplate.query(sql,  new Object[]{ "%" + title + "%"},  new BookRowMapper());
        return books;
    }

    public List<BookEntity> getBooksByAuthor(String name) {

        var sql = "SELECT *\n" +
                "\tFROM book b\n" +
                "JOIN author \"a\" ON b.author_id = \"a\".id\n" +
                "WHERE \"a\".name like ?";
        var books = jdbcTemplate.query(sql,  new Object[]{ "%" + name + "%"},  new BookRowMapper());
        return books;
    }

    public List<BookEntity> getBooksByGenre(String genre) {

        var sql = "SELECT *\n" +
                "\tFROM book b\n" +
                "JOIN genre \"g\" ON b.genre_id = \"g\".id\n" +
                "WHERE \"g\".name like ?";
        var books = jdbcTemplate.query(sql,  new Object[]{ "%" + genre + "%"},  new BookRowMapper());
        return books;
    }

    public void addBook(final BookEntity book) {
        jdbcTemplate.update("insert into teacher(title, author_id, genre_id, icon_id, file_id) values(?,?,?,?,?)",
                new Object[] { book.getTitle(), book.getAuthorId(), book.getGenreId(), book.getIconId(), book.getFileId() });
    }

    public void updateBook(final BookEntity book) {
        jdbcTemplate.update("update teacher set title = ?, author_id = ?, genre_id = ?, icon_id = ?, file_id = ? where id = ?",
                new Object[] {book.getTitle(), book.getAuthorId(), book.getGenreId(), book.getIconId(), book.getFileId(), book.getId() });
    }

    public void deleteBook(final long id) {
        jdbcTemplate.update("delete from teacher where id = ?", new Object[] { id });
    }
}
