package com.example.book_imdb.repositories.bookrepository;

import com.example.book_imdb.entities.BookEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BookRowMapper implements RowMapper<BookEntity> {
    @Override
    public BookEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        BookEntity book = new BookEntity(
                rs.getInt("book_id"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getString("description"),
                rs.getDate("release_date").toLocalDate(),
                rs.getBigDecimal("rating"));
        return book;

    }
}

