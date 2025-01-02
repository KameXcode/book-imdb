package com.example.book_imdb.repositories;

import com.example.book_imdb.entities.BookEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookRepository{


    private final JdbcTemplate jdbcTemplate;

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BookEntity> findAllBooks(){
        String sql = "SELECT * FROM books";

        RowMapper<BookEntity> mapper = new RowMapper<BookEntity>() {
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
        };
         List<BookEntity> books = jdbcTemplate.query(sql, mapper);
         return books;
    }

}
