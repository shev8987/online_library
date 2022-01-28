package com.shev8987.mapper;

import com.shev8987.entity.BookEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class BookRowMapper implements RowMapper<BookEntity> {

    @Override
    public BookEntity mapRow(ResultSet rs, int row) throws SQLException {

        return new BookEntity(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getLong("author_id"),
                rs.getLong("genre_id"),
                rs.getLong("icon_id"),
                rs.getLong("file_id")
        );
    }

}
